package com.mystudy.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 여러개의 DAO 파일에서 중복된 부분 처리


public class JdbcUtil {

	// static 역할
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "javadb";
			String password = "12345";
			
			con = DriverManager.getConnection(url, user, password);		
			con.setAutoCommit(false); // 자동커밋 막음
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}















