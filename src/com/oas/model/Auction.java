package com.oas.model;

import java.sql.Date;

/*
* This Model class is to create connectivity between auctionDAO and auction_master table in DBMS using Getter and Setter methods.
*/

public class Auction {
	
	int seqNumber;
	int productID;
	double minBidValue;
	Date bidStartDate;
	Date bidEndDate;
	int sellerID;
	double soldPrice;
	String status;
	
	public Auction() {
	
	}

	public Auction(int seqNumber, int productID, double minBidValue, Date bidStartDate, Date bidEndDate, int sellerID, double soldPrice,
			String status) {
		this.seqNumber = seqNumber;
		this.productID=productID;
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.sellerID = sellerID;
		this.soldPrice = soldPrice;
		this.status = status;
	}
	
	public Auction( int productID, double minBidValue, Date bidStartDate, Date bidEndDate, int sellerID, double soldPrice,
			String status) {
		this.productID=productID;
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.sellerID = sellerID;
		this.soldPrice = soldPrice;
		this.status = status;
	}

	public int getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public double getMinBidValue() {
		return minBidValue;
	}

	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}

	public java.sql.Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public int getsellerID() {
		return sellerID;
	}

	public void setsellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Auction [seqNumber=" + seqNumber + ", productID=" + productID + ", minBidValue=" + minBidValue
				+ ", bidStartDate=" + bidStartDate + ", bidEndDate=" + bidEndDate + ", sellerID=" + sellerID
				+ ", soldPrice=" + soldPrice + ", status=" + status + "]";
	}

}
