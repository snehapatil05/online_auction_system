package com.oas.serviceWithTransactions;

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
			userDAO.connection.setAutoCommit(false);
			allUsers = this.userDAO.selectAllUsers();
			userDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			userDAO.connection.rollback();
		}
		return allUsers;
	}

	public User listUserByID(int id) throws DBException, DataAccessException, SQLException {

		User user = new User();

		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			userDAO.connection.setAutoCommit(false);
			user = this.userDAO.selectUserByID(id);
			userDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			userDAO.connection.rollback();
		}
		return user;
		
	}

	public void deleteUser(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			userDAO.connection.setAutoCommit(false);
			this.userDAO.removeUser(uid);
			userDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			userDAO.connection.rollback();
		}	
	}

	public void saveUser(User user) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			userDAO.connection.setAutoCommit(false);
			this.userDAO.addUser(user);
			userDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			userDAO.connection.rollback();
		}	
	}

	public void editUser(User user) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());

		try {
			userDAO.connection.setAutoCommit(false);
			this.userDAO.updateUser(user);
			userDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			userDAO.connection.rollback();
		}	
	}
		

	// Category-----------------------------------------------------------------------

	public List<Category> listAllCategories() throws DBException, DataAccessException, SQLException {

		List<Category> allCategories = new ArrayList<Category>();

		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			categoryDAO.connection.setAutoCommit(false);
			allCategories = this.categoryDAO.selectAllCategories();
			categoryDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			categoryDAO.connection.rollback();
		}
		return allCategories;
	}

	public Category listCategoryByID(int id) throws DBException, DataAccessException, SQLException {

		Category category = new Category();

		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			categoryDAO.connection.setAutoCommit(false);
			category = this.categoryDAO.selectCategoryByID(id);
			categoryDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			categoryDAO.connection.rollback();
		}
		return category;
		
	}

	public void deleteCategory(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			categoryDAO.connection.setAutoCommit(false);
			this.categoryDAO.removeCategory(uid);
			categoryDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			categoryDAO.connection.rollback();
		}	
	}

	public void saveCategory(Category category) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			categoryDAO.connection.setAutoCommit(false);
			this.categoryDAO.addCategory(category);
			categoryDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			categoryDAO.connection.rollback();
		}
	}

	public void editCategory(Category category) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());

		try {
			categoryDAO.connection.setAutoCommit(false);
			this.categoryDAO.updateCategory(category);
			categoryDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			categoryDAO.connection.rollback();
		}	
	}


	// Bid-------------------------------------------------------------------------------

	public void saveBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			bidDAO.connection.setAutoCommit(false);
			this.bidDAO.addBid(bid);
			bidDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			bidDAO.connection.rollback();
		}
	}

	public void editBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			bidDAO.connection.setAutoCommit(false);
			this.bidDAO.updateBid(bid);
			bidDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			bidDAO.connection.rollback();
		}	
	}

	public Bid listBidByID(int id) throws DBException, DataAccessException {
		Bid bid = new Bid();

		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());

		try {
			bidDAO.connection.setAutoCommit(false);
			bid = this.bidDAO.selectBidByID(id);
			bidDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			bidDAO.connection.rollback();
		}
		return bid;
	}

	
	// Product-----------------------------------------------------------------------

	public List<Product> listAllProducts() throws DBException, DataAccessException, SQLException {

		List<Product> allProducts = new ArrayList<Product>();

		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());

		try {
			productDAO.connection.setAutoCommit(false);
			allProducts = this.productDAO.selectAllProducts();
			productDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			productDAO.connection.rollback();
		}
		return allProducts;
	}

	public Product listProductByID(int id) throws DBException, DataAccessException, SQLException {

		Product product = new Product();

		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());

		try {
			productDAO.connection.setAutoCommit(false);
			product = this.productDAO.selectProductByID(id);
			productDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			productDAO.connection.rollback();
		}
		return product;
		
	}

	
	// Auction------------------------------------------------------------------------

	public List<Auction> listAllAuctions() throws DBException, DataAccessException, SQLException {

		List<Auction> allAuctions = new ArrayList<Auction>();

		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			auctionsDAO.connection.setAutoCommit(false);
			allAuctions = this.auctionsDAO.selectAllAuctions();
			auctionsDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			auctionsDAO.connection.rollback();
		}
		return allAuctions;
	}

	public Auction listAuctionByID(int id) throws DBException, DataAccessException, SQLException {

		Auction auctions = new Auction();

		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			auctionsDAO.connection.setAutoCommit(false);
			auctions = this.auctionsDAO.selectAuctionByID(id);
			auctionsDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			auctionsDAO.connection.rollback();
		}
		return auctions;
		
	}

	public void deleteAuction(int uid) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			auctionsDAO.connection.setAutoCommit(false);
			this.auctionsDAO.removeAuction(uid);
			auctionsDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			auctionsDAO.connection.rollback();
		}	
	}

	public void saveAuction(Auction auctions) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			auctionsDAO.connection.setAutoCommit(false);
			this.auctionsDAO.addAuction(auctions);
			auctionsDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			auctionsDAO.connection.rollback();
		}	
	}

	public void editAuction(Auction auctions) throws DBException, InsertFailedException, SQLException {
		
		DBUtil.open();
		this.auctionsDAO.setConnection(DBUtil.getConnection());

		try {
			auctionsDAO.connection.setAutoCommit(false);
			this.auctionsDAO.updateAuction(auctions);
			auctionsDAO.connection.commit();

		} catch (SQLException e) {
			System.out.println("Transaction is being rolled back due to SQLException!");
			auctionsDAO.connection.rollback();
		}	
	}
		
