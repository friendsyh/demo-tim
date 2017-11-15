package com.tim.common.designpatter.singleton.dbconnpool;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 数据库连接池，管理着N个连接
 * Created by tim.syh on 2016/8/14.
 */
@Data
public class DBConnectionPool {

    /** 所有可用的conn集合 */
    private Vector<Connection> freeConnections;

    /** 最大的连接数 */
    private int maxConnCount;

    /** 目前的连接数 */
    private int preConnCount;

    public DBConnectionPool(int maxConnCount){
        this.maxConnCount = maxConnCount;
        this.freeConnections = new Vector<Connection>();
    }

    /**
     * 获取连接，如果池子中有，就直接获取，如果没有，就新建.
     * @return
     */
    public synchronized Connection getConnection(){
        Connection connection = null;
        //如果池子中存在可用的连接，直接获取第一个,并且在池子中移除这个
        if(freeConnections != null && freeConnections.size() > 0){
            connection = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try{
                if(connection.isClosed()){
                    getConnection();
                }
            } catch (SQLException e){
                e.printStackTrace();
                getConnection();
            }
        } else if(maxConnCount == 0 || preConnCount < maxConnCount){
            connection = newConnection();
        }

        if(connection != null){
            preConnCount++;
        }

        return connection;
    }

    private Connection newConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "789456");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("创建新的connection失败");
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            return null;
        }
        return connection;
    }

    /**
     * 从连接池获取可用连接.可以指定客户程序能够等待的最长时间
     * 参见前一个getConnection()方法.
     *
     * @param timeout
     *            以毫秒计的等待时间限制
     */
    public synchronized Connection getConnection(long timeout) {
        long startTime = System.currentTimeMillis();
        Connection conn = null;//定义连接标量
        while ((conn = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - startTime) >= timeout) {
                // wait()返回的原因是超时
                return null;
            }
        }
        return conn;
    }

    public synchronized void freeConnection(Connection connection){
        freeConnections.addElement(connection);
        preConnCount--;
        preConnCount = preConnCount < 0 ? 0 : preConnCount;
        notifyAll();
        System.out.println("free a connection");
    }
}
