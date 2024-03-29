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
		InputStream inputStream = null;
		Properties properties = null;
		try {
			inputStream = new FileInputStream("C://HSBC/online_auction_system/resources/config.properties");
			properties = new Properties();
			properties.load(inputStream);
			Class.forName(properties.getProperty("derby.driver"));
			String url = properties.getProperty("derby.connection.url")+";user="+properties.getProperty("derby.username")+";password="+properties.getProperty("derby.password");
			DBUtil.connection = DriverManager.getConnection(url);
			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DBException("Driver Not Found!!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("URL is incorrect!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

