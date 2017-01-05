package com.tim.common.designPatter.singleton.dbconnpool;

import lombok.Data;

import java.sql.Connection;

/**
 * 数据库连接池的管理类
 * 一个单例模式
 * Created by tim.syh on 2016/8/14.
 */
@Data
public class DBConnectionManager {

    //单例对象
    private static DBConnectionManager dbConnectionManager;

    //连接池对象，因为manager对象是唯一的，所以这个对象也是唯一的
    private DBConnectionPool pool;

    // 连接的客户端
    private static int clients;


    //构造方法私有
    private DBConnectionManager(){
        this.init();
    }

    //初始化的时候需要加载驱动，然后创建连接池对象
    private void init(){
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            pool = new DBConnectionPool(2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized DBConnectionManager getInstance(){
        if(dbConnectionManager == null){
            dbConnectionManager = new DBConnectionManager();
        }
        clients++;
        return dbConnectionManager;
    }

    public Connection getConnection(){
        return pool.getConnection();
    }

    public void freeConnection(Connection connection){
        pool.freeConnection(connection);
    }

}
