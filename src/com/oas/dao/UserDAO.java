package com.oas.dao;

/*
 * Class to enable user to talk to database server.
 */

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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * It has all the functionalities to be done on user_master table
 */

public class UserDAO {
	
/*
 * Establishing connection between user_master table and client server
 */
	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

/*
 * Function created to add a new user inside user_master table 
 */
	public void addUser(User user) throws InsertFailedException, UserAlreadyExistException {
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
	
	
/*
 * Function created to make changes in the existing user details inside user_master table 
 */
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
	
	
/*
 * Function created to delete a user from user_master table 
 */
	public void deleteUser(int uid) throws InsertFailedException {
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
	
	
/*
 * Function created to display all users from user_master table 
 */
	public List<User> selectAllUsers() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM USER_MASTER");
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
		
/*
 * Function created to display user details on basis of userID from user_master table 
 */
	public User selectUserByID(int id) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM USER_MASTER WHERE UID=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			User user= new User();
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

		
/*
 * Function created for validation of users existence in user_master table at time of registration and if user name is found in 
 * database then function does not allow user to register with same name 
 */
	public boolean checkIfUserExists(String name) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = this.connection.prepareStatement("SELECT PASSWORD FROM USER_MASTER WHERE USER_NAME=?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()==false) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from USER_MASTER table");
		}
	}

		
/*
 * Function created for authentication of user by checking if the input user and its registered password match user_master table
 * at time of login 
 */

	public boolean checkAuthenticity(String name, String password) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String passwordFromDB= null;
		StringBuilder hash = new StringBuilder();
		try {
			preparedStatement = this.connection.prepareStatement("SELECT PASSWORD FROM USER_MASTER WHERE USER_NAME=?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				passwordFromDB= resultSet.getString(1);
			}
			if(passwordFromDB.equals(password)) {
				return true;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from USER_MASTER table");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}
	
/*
 * Encrypting password using SHA-512 algorithm
 */
	public String get_SHA_512_SecurePassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
/*
 * Function created for validation of users email existence in user_master table at time of registration and if user email is found in 
 * database then function does not allow user to register with same email 
 */
	public boolean checkIfEmailExists(String email) {
		boolean emailExists=false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = this.connection.prepareStatement("SELECT EMAIL FROM USER_MASTER");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String getEmail=resultSet.getString(1);
				if(getEmail.equals(email)) {
					emailExists = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailExists;
	}
	
/*
 * Function created for validation of users phoneNo existence in user_master table at time of registration and if user phoneNo is found in 
 * database then function does not allow user to register with same phoneNo 
 */
	
	public boolean checkIfPhoneNumberExists(String phoneNo) {
		boolean phoneNoExists=false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = this.connection.prepareStatement("SELECT PHONE_NUMBER FROM USER_MASTER");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String getPhoneNo=resultSet.getString(1);
				if(getPhoneNo.equals(phoneNo)) {
					phoneNoExists = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phoneNoExists;
	}
}
