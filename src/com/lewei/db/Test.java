package com.lewei.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	private static final String URL = "jdbc:mysql://172.21.2.216:3306/warning_light";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "";
	
	private static Connection conn = null;

	static {
		// 1.����������������ƣ�
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// 2.������ݿ�����
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	public static Connection getConn() {
		return conn;
	}
	
	public static void main(String[] args) throws Exception {

		// 3.ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		System.out.println(conn);
		// 4.ͨ����ѯ���ؽ��
		ResultSet rs = statement.executeQuery("select * from tpplan");
		// 5.ѭ��ȥ�� rs �еĽ��
		while(rs.next()){
			System.out.println(rs.getObject(2));
		}
		
	}

}
