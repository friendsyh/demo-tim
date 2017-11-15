package com.tim.common.designpatter.singleton.dbconnpool;

import java.sql.Connection;

/**
 * Created by tim.syh on 2016/8/14.
 */
public class TestMain {

    public static void main(String[] args) {
        DBConnectionManager connectionManager = DBConnectionManager.getInstance();

        Connection conn1 = connectionManager.getConnection();
        Connection conn2 = connectionManager.getConnection();
        connectionManager.freeConnection(conn1);
        Connection conn3 = connectionManager.getConnection();
        Connection conn4 = connectionManager.getConnection();
        System.out.println(" conn1 == " + conn1);
        System.out.println(" conn2 == " + conn2);
        System.out.println(" conn3 == " + conn3);
        System.out.println(" conn4 == " + conn4);

        connectionManager.freeConnection(conn2);
        connectionManager.freeConnection(conn3);
        connectionManager.freeConnection(conn4);
    }

}
