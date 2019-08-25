package com.oas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Auction;

public class AuctionDAO {	

	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void addAuction(Auction auction) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO AUCTION_MASTER( PRODUCT_ID, MIN_BID_VALUE, BID_START_DATE, BID_END_DATE, USER_ID, SOLD_PRICE, STATUS) VALUES(?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, auction.getProductID());
			preparedStatement.setDouble(2, auction.getMinBidValue());
			preparedStatement.setDate(4, auction.getBidStartDate());
			preparedStatement.setDate(5, auction.getBidEndDate());
			preparedStatement.setInt(6, auction.getsellerID());
			preparedStatement.setDouble(7, auction.getSoldPrice());
			preparedStatement.setString(8, auction.getStatus());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not save in AUCTION_MASTER table");

		}
	}
	
	//Update Auction by SeqNumber
	public void updateAuction(Auction auction) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("UPDATE AUCTION_MASTER SET PRODUCT_ID=?, MIN_BID_VALUE=?, BID_START_DATE=?,BID_END_DATE=?, USER_ID=?, SOLD_PRICE=?, STATUS=? WHERE SEQ_NO=?");
			
			preparedStatement.setInt(1, auction.getProductID());
			preparedStatement.setDouble(2, auction.getMinBidValue());
			preparedStatement.setDate(3, auction.getBidStartDate());
			preparedStatement.setDate(4, auction.getBidEndDate());
			preparedStatement.setInt(5, auction.getsellerID());
			preparedStatement.setDouble(6, auction.getSoldPrice());
			preparedStatement.setString(7, auction.getStatus());
			preparedStatement.setInt(8, auction.getSeqNumber());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not update AUCTION_MASTER table");

		}
	}
	
	
	public void deleteAuction(int seqNo) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("DELETE FROM AUCTION_MASTER WHERE SEQ_NO=?");
			preparedStatement.setInt(1, seqNo);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not delete record from AUCTION_MASTER table");

		}
	}
	
	public List<Auction> selectAllAuctions() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Auction> auctions = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM AUCTION_MASTER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Auction auction=new Auction();
				auction.setSeqNumber(resultSet.getInt(1));
				auction.setProductID(resultSet.getInt(2));
				auction.setMinBidValue(resultSet.getDouble(3));
				auction.setBidStartDate(resultSet.getDate(4));
				auction.setBidEndDate(resultSet.getDate(5));
				auction.setsellerID(resultSet.getInt(6));
				auction.setSoldPrice(resultSet.getDouble(7));
				auction.setStatus(resultSet.getString(8));
				
				auctions.add(auction);
			}
			return auctions;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from AUCTION_MASTER table");
		}

	}

	public List<Auction> selectAuctionBySequenceNo(int seqNo) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Auction> auctions = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM AUCTION_MASTER WHERE SEQ_NO=?");
			preparedStatement.setInt(1, seqNo);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Auction auction=new Auction();
				auction.setSeqNumber(resultSet.getInt(1));
				auction.setMinBidValue(resultSet.getDouble(2));
				auction.setBidStartDate(resultSet.getDate(3));
				auction.setBidEndDate(resultSet.getDate(4));
				auction.setsellerID(resultSet.getInt(5));
				auction.setSoldPrice(resultSet.getDouble(6));
				auction.setStatus(resultSet.getString(7));
				
				auctions.add(auction);
			}
			return auctions;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from AUCTION_MASTER table");
		}

	}
	
	public List<Auction> selectAuctionByProductID(int prodID) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Auction> auctions = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM AUCTION_MASTER WHERE PRODUCT_ID=?");
			preparedStatement.setInt(1, prodID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Auction auction=new Auction();
				auction.setSeqNumber(resultSet.getInt(1));
				auction.setMinBidValue(resultSet.getDouble(2));
				auction.setBidStartDate(resultSet.getDate(3));
				auction.setBidEndDate(resultSet.getDate(4));
				auction.setsellerID(resultSet.getInt(5));
				auction.setSoldPrice(resultSet.getDouble(6));
				auction.setStatus(resultSet.getString(7));
				
				auctions.add(auction);
			}
			return auctions;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from AUCTION_MASTER table");
		}

	}
	
}
