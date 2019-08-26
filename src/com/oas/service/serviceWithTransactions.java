package com.oas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oas.dao.UserDAO;
import com.oas.dao.AuctionDAO;
import com.oas.dao.BidDAO;
import com.oas.dao.CategoryDAO;
import com.oas.dao.ProductDAO;
import com.oas.exception.DBException;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Auction;
import com.oas.model.Bid;
import com.oas.model.Category;
import com.oas.model.Product;
import com.oas.model.User;
import com.oas.util.DBUtil;

/*
 Service with Transactions
 */

public class UserService {

	UserDAO userDAO = new UserDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	BidDAO bidDAO = new BidDAO();
	ProductDAO productDAO = new ProductDAO();
	AuctionDAO auctionDAO = new AuctionDAO();

	// User--------------------------------------------------------------------

	public List<User> listAllUsers() throws DBException, DataAccessException, SQLException {

		List<User> allUsers = new ArrayList<User>();

		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			allUsers = this.userDAO.selectAllUsers();
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return allUsers;
	}

	public User listUserByID(int id) throws DBException, DataAccessException, SQLException {

		User user = new User();

		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			user = this.userDAO.selectUserByID(id);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return user;
		
	}

	public void deleteUser(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.userDAO.removeUser(uid);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public void saveUser(User user) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.userDAO.addUser(user);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public void editUser(User user) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.userDAO.updateUser(user);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}
		

	// Category-----------------------------------------------------------------------

	public List<Category> listAllCategories() throws DBException, DataAccessException, SQLException {

		List<Category> allCategories = new ArrayList<Category>();

		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			allCategories = this.categoryDAO.selectAllCategories();
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return allCategories;
	}

	public Category listCategoryByID(int id) throws DBException, DataAccessException, SQLException {

		Category category = new Category();

		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			category = this.categoryDAO.selectCategoryByID(id);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return category;
		
	}

	public void deleteCategory(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.categoryDAO.removeCategory(uid);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public void saveCategory(Category category) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.categoryDAO.addCategory(category);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
	}

	public void editCategory(Category category) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.categoryDAO.updateCategory(category);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}


	// Bid-------------------------------------------------------------------------------

	public void saveBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.bidDAO.addBid(bid);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
	}

	public void editBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.bidDAO.updateBid(bid);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public Bid listBidByID(int id) throws DBException, DataAccessException {
		Bid bid = new Bid();

		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			bid = this.bidDAO.selectBidByID(id);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return bid;
	}

	
	// Product-----------------------------------------------------------------------

	public List<Product> listAllProducts() throws DBException, DataAccessException, SQLException {

		List<Product> allProducts = new ArrayList<Product>();

		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			allProducts = this.productDAO.selectAllProducts();
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return allProducts;
	}

	public Product listProductByID(int id) throws DBException, DataAccessException, SQLException {

		Product product = new Product();

		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			product = this.productDAO.selectProductByID(id);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return product;
		
	}

	
	// Auction------------------------------------------------------------------------

	public List<Auction> listAllAuctions() throws DBException, DataAccessException, SQLException {

		List<Auction> allAuctions = new ArrayList<Auction>();

		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			allAuctions = this.auctionsDAO.selectAllAuctions();
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return allAuctions;
	}

	public Auction listAuctionByID(int id) throws DBException, DataAccessException, SQLException {

		Auction auctions = new Auction();

		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			auctions = this.auctionsDAO.selectAuctionByID(id);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}
		return auctions;
		
	}

	public void deleteAuction(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.auctionsDAO.removeAuction(uid);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public void saveAuction(Auction auctions) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.auctionsDAO.addAuction(auctions);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}

	public void editAuction(Auction auctions) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			DBUtil.beginTx();
			this.auctionsDAO.updateAuction(auctions);
			DBUtil.commitTx();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			DBUtil.rollbackTx();
		}	
	}
		
