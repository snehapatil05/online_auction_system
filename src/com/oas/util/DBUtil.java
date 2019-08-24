package com.oas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.oas.exception.DBException;

public class DBUtil {
	static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DBUtil.connection = connection;
	}
	
	public static void open() throws DBException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			DBUtil.connection = DriverManager.getConnection("jdbc:derby://localhost:4444/C:/DB/training");
			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DBException("Driver Not Found!!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("URL is incorrect!!");
		}
	}

	public static void beginTx() throws DBException {
		try {
			DBUtil.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("could not begin transaction on DB connection");
		}
	}
	
	public static void commitTx() throws DBException {
		try {
			DBUtil.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("could not commit transaction on DB connection");
		}
	}
	
	public static void rollbackTx() throws DBException {
		try {
			DBUtil.connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("could not rollback transaction on DB connection");
		}
	}
	
	public static void close() throws DBException {
		try {
			DBUtil.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Connection cannot be closed");
		}
	}
	
	
}

