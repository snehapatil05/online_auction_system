package com.oas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.exception.UserAlreadyExistException;
import com.oas.model.User;

/*
 
 */

public class UserDAO {
	
	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void registerUser(User user) throws InsertFailedException, UserAlreadyExistException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO USER_MASTER(NAME, DOB, EMAIL, PHONE_NUMBER, USER_NAME, PASSWORD, ADDRESS, USER_TYPE,WALLET_AMOUNT)VALUES(?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setDate(2, user.getDob());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getUserType());
			preparedStatement.setDouble(9, user.getWalletAmount());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not save in USER_MASTER table");

		}
	}
	
	public void updateUser(User user) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("UPDATE USER_MASTER SET NAME=?, DOB=?, EMAIL=?,PHONE_NUMBER=?, USER_NAME=?, PASSWORD=?, ADDRESS=?, USER_TYPE=?,WALLET_AMOUNT=? WHERE UID=?");
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setDate(2, user.getDob());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getUserType());
			preparedStatement.setDouble(9, user.getWalletAmount());
			preparedStatement.setInt(10, user.getUserID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not update USER_MASTER table");

		}
	}
	
	public void removeUser(int uid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("DELETE FROM USER_MASTER WHERE UID=?");
			preparedStatement.setInt(1, uid);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not delete record from USER_MASTER table");

		}
	}
	
	public User selectAllUsers() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user= new User();
		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM USER_MASTER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			
				user.setUserID(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setDob(resultSet.getDate(3));
				user.setEmail(resultSet.getString(4));
				user.setPhoneNumber(resultSet.getString(5));
				user.setUserName(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setAddress(resultSet.getString(8));
				user.setUserType(resultSet.getString(9));
				user.setWalletAmount(resultSet.getDouble(10));
				
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from USER_MASTER table");
		}

	}

	public List<User> selectUserByID(int id) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM USER_MASTER WHERE UID=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user= new User();
				user.setUserID(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setDob(resultSet.getDate(3));
				user.setEmail(resultSet.getString(4));
				user.setPhoneNumber(resultSet.getString(5));
				user.setUserName(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setAddress(resultSet.getString(8));
				user.setUserType(resultSet.getString(9));
				user.setWalletAmount(resultSet.getDouble(10));
				
				users.add(user);

			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from USER_MASTER table");
		}

	}



}
