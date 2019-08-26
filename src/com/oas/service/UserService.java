package com.oas.service;

import java.util.List;

import com.oas.dao.UserDAO;
import com.oas.dao.AuctionDAO;
import com.oas.dao.BidDAO;
import com.oas.dao.CategoryDAO;
import com.oas.dao.ProductDAO;
import com.oas.exception.DBException;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.exception.UserNotFoundException;
import com.oas.exception.InvalidOldPasswordException;
import com.oas.exception.UserAlreadyExistException;
import com.oas.model.Auction;
import com.oas.model.Bid;
import com.oas.model.Category;
import com.oas.model.Product;
import com.oas.model.User;
import com.oas.util.DBUtil;

/*
 Service W/O Transactions
 */

public class UserService {

	UserDAO userDAO = new UserDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	BidDAO bidDAO = new BidDAO();
	ProductDAO productDAO = new ProductDAO();
	AuctionDAO auctionDAO = new AuctionDAO();

	// User--------------------------------------------------------------------

	public boolean findUsername() throws DataAccessException, UserNotFoundException{
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.checkIfUserExists();
	}
	
	public boolean authenticateUser(String username, String password) throws DataAccessException, InvalidOldPasswordException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.checkAuthenticity(username,password);
	}
	
	public List<User> listAllUsers() throws DBException, DataAccessException, UserNotFoundException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectAllUsers();
	}
	

	public User listUserByID(int id) throws DBException, DataAccessException, UserNotFoundException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectUserByID(id);
	}

	public void deleteUser(int uid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		this.userDAO.removeUser(uid);
	}

	public void saveUser(User user) throws DBException, InsertFailedException, UserAlreadyExistException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		this.userDAO.addUser(user);
	}

	public void editUser(User user) throws DBException, InsertFailedException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		this.userDAO.updateUser(user);
	}

	// Category-----------------------------------------------------------------------

	public List<Category> listAllCategories() throws DBException, DataAccessException {
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());
		return this.categoryDAO.selectAllCategories();
	}

	public Category listCategoryByID(int id) throws DBException, DataAccessException {
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());
		return this.categoryDAO.selectCategoryByID(id);
	}

	public void deleteCategory(int uid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());
		this.categoryDAO.removeCategory(uid);
	}

	public void saveCategory(Category category) throws DBException, InsertFailedException {
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());
		this.categoryDAO.addCategory(category);
	}

	public void editCategory(Category category) throws DBException, InsertFailedException {
		DBUtil.open();
		this.categoryDAO.setConnection(DBUtil.getConnection());
		this.categoryDAO.updateCategory(category);
	}

	// Bid-------------------------------------------------------------------------------

	public void saveBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());
		this.bidDAO.addBid(bid);
	}

	public void editBid(Bid bid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());
		this.bidDAO.updateBid(bid);
	}

	public Bid listBidByID(int id) throws DBException, DataAccessException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());
		return this.bidDAO.selectBidByID(id);
	}

	// Product-----------------------------------------------------------------------

	public List<Product> listAllProducts() throws DBException, DataAccessException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectAllProducts();
	}

	public Product listProductByID(int id) throws DBException, DataAccessException{
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectProductByID(id);
	}
		
	//Auction------------------------------------------------------------------------
	
	public List<Auction> listAllAuctions() throws DBException, DataAccessException {
		DBUtil.open();
		this.auctionDAO.setConnection(DBUtil.getConnection());
		return this.auctionDAO.selectAllAuctions();
	}

	public Auction listAuctionByID(int id) throws DBException, DataAccessException {
		DBUtil.open();
		this.auctionDAO.setConnection(DBUtil.getConnection());
		return this.auctionDAO.selectAuctionByID(id);
	}

	public void deleteAuction(int uid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.auctionDAO.setConnection(DBUtil.getConnection());
		this.auctionDAO.removeAuction(uid);
	}

	public void saveAuction(Auction auction) throws DBException, InsertFailedException {
		DBUtil.open();
		this.auctionDAO.setConnection(DBUtil.getConnection());
		this.auctionDAO.addAuction(auction);
	}

	public void editAuction(Auction auction) throws DBException, InsertFailedException {
		DBUtil.open();
		this.auctionDAO.setConnection(DBUtil.getConnection());
		this.auctionDAO.updateAuction(auction);
	}
	
}
