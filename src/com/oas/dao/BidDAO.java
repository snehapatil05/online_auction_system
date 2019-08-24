package com.oas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Bid;

public class BidDAO {
	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void saveBid(Bid bid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO BID_MASTER( USER_ID, PRODUCT_ID, BID_VALUE, STATUS) VALUES(?,?,?,?)");
			
			preparedStatement.setInt(1, bid.getUserID());
			preparedStatement.setInt(2, bid.getProductID());
			preparedStatement.setDouble(3, bid.getBidValue());
			preparedStatement.setString(4, bid.getStatus());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not save in BID_MASTER table");

		}
	}
	
	public void updateBid(Bid bid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("UPDATE BID_MASTER SET USER_ID=?, PRODUCT_ID=?, BID_VALUE=?, STATUS=?  WHERE BID_ID=?");
			preparedStatement.setInt(1, bid.getUserID());
			preparedStatement.setInt(2, bid.getProductID());
			preparedStatement.setDouble(3, bid.getBidValue());
			preparedStatement.setString(4, bid.getStatus());
			preparedStatement.setInt(5, bid.getBidID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not update BID_MASTER table");

		}
	}
	
	public void removeBid(int bid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("DELETE FROM BID_MASTER WHERE BID_ID=?");
			preparedStatement.setInt(1, bid);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not delete record from BID_MASTER table");

		}
	}
	
	public List<Bid> selectAllBids() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Bid> bids = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM BID_MASTER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Bid bid= new Bid();
				bid.setBidID(resultSet.getInt(1));
				bid.setUserID(resultSet.getInt(2));
				bid.setProductID(resultSet.getInt(3));
				bid.setBidValue(resultSet.getDouble(4));
				bid.setStatus(resultSet.getString(5));
				
				bids.add(bid);
			}
			return bids;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from BID_MASTER table");
		}

	}

	public Bid selectBidByID(int bid) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM BID_MASTER WHERE BID_ID=?");
			preparedStatement.setInt(1, bid);
			resultSet = preparedStatement.executeQuery();
			Bid bid1= new Bid();
			while (resultSet.next()) {
				
				bid1.setBidID(resultSet.getInt(1));
				bid1.setUserID(resultSet.getInt(2));
				bid1.setProductID(resultSet.getInt(3));
				bid1.setBidValue(resultSet.getDouble(4));
				bid1.setStatus(resultSet.getString(5));
				
			}
			return bid1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from BID_MASTER table");
		}

	}
	
	public Bid highestBid(int pid) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int maxBidValue = 0;
		int bid = 0;
		try {
			preparedStatement = this.connection.prepareStatement("SELECT MAX(BID_VALUE) AS MAX_BID_VALUE FROM BID_MASTER GROUP BY PRODUCT_ID HAVING PRODUCT_ID=?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			Bid bid1= new Bid();
			while (resultSet.next()) {
				 maxBidValue = resultSet.getInt(1);
			}
			if(maxBidValue!=0) {
				preparedStatement = this.connection.prepareStatement("SELECT BID_ID FROM BID_MASTER WHERE BID_VALUE=?");
				preparedStatement.setInt(1, maxBidValue);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					 bid = resultSet.getInt(1);
				}
			}
			
			if(bid!=0) {
				preparedStatement = this.connection.prepareStatement("SELECT * FROM BID_MASTER WHERE BID_ID=?");
				preparedStatement.setInt(1, bid);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					bid1.setBidID(resultSet.getInt(1));
					bid1.setUserID(resultSet.getInt(2));
					bid1.setProductID(resultSet.getInt(3));
					bid1.setBidValue(resultSet.getDouble(4));
					bid1.setStatus(resultSet.getString(5));
				}
			}
			return bid1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from BID_MASTER table");
		}

	}
	 


}
