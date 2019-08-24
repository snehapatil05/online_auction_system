package com.oas.model;

import java.sql.Date;

public class User {
	
	int userID;
	String name;
	Date dob;
	String email;
	String phoneNumber;
	String userName;
	String password;
	String address;
	String userType;
	double walletAmount;
	
	public User() {
		
	}

	public User(int userID, String name, Date dob, String email, String phoneNumber, String userName,
			String password, String address, String userType, double walletAmount) {
		
		this.userID = userID;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.userType = userType;
		this.walletAmount = walletAmount;
	}
	
	public User(String name, Date dob, String email, String phoneNumber, String userName,
			String password, String address, String userType, double walletAmount) {
		
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.userType = userType;
		this.walletAmount = walletAmount;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	
	
}
