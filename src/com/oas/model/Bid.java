package com.oas.model;

public class Bid {
	int bidID;
	int userID;
	int productID;
	double bidValue;
	String status;
	
	public Bid() {
		
	}

	public Bid(int bidID, int userID, int productID, double bidValue, String status) {
		this.bidID = bidID;
		this.userID = userID;
		this.productID = productID;
		this.bidValue = bidValue;
		this.status = status;
	}
	
	public Bid(int userID, int productID, double bidValue, String status) {
		this.userID = userID;
		this.productID = productID;
		this.bidValue = bidValue;
		this.status = status;
	}

	public int getBidID() {
		return bidID;
	}

	public void setBidID(int bidID) {
		this.bidID = bidID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public double getBidValue() {
		return bidValue;
	}

	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
