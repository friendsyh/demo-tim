package com.tim.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 数据库的jdbc操作。
 * 编写的jdbc链接数据库的基本代码，打开链接，创建链接，查询并且返回结果
 * @author suyanghua
 *
 */
public class DBDemo {

	public static void main(String[] args) {
		Connection connection = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String userName = "1001yw";
		String password = "DJ19058hao123";
		String sql = "select 1 from dual";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.println("ID:" + rs.getInt(1) + " name:" + rs.getString(2) + " createTime:" + rs.getString(4));
				System.out.println("查询成功");
			}
			if (rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
