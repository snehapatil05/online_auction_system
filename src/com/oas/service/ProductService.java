package com.oas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oas.dao.BidDAO;
import com.oas.dao.ProductDAO;
import com.oas.dao.UserDAO;
import com.oas.exception.DBException;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.exception.UserAlreadyExistException;
import com.oas.model.Bid;
import com.oas.model.Product;
import com.oas.model.User;
import com.oas.util.DBUtil;

public class ProductService {
	

	UserDAO userDAO = new UserDAO();
	BidDAO bidDAO = new BidDAO();
	ProductDAO productDAO = new ProductDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	
	// Category-----------------------------------------------------------------------
	
	public List<Category> listAllByCategory() throws DBException, DataAccessException {
		DBUtil.open();
		this.CategoryDAO.setConnection(DBUtil.getConnection());
		return this.CategoryDAO.selectAllByCategory();
	}
	
	// Bid-------------------------------------------------------------------------------
	
	public List<Bid> listAllBids() throws DBException, DataAccessException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());
		return this.bidDAO.selectAllBids();
	}
	
	
	// User--------------------------------------------------------------------

	public List<User> listAllUsers() throws DBException, DataAccessException, UserAlreadyExistException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectAllUsers();
	}

	public User listUserByID(int id) throws DBException, DataAccessException, UserAlreadyExistException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectUserByID(id);
	}
	
	// Product-----------------------------------------------------------------------
	
	public List<Product> listAllProduct() throws DBException, DataAccessException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectAllProducts();
	}

	public Product listProductByID(int pid) throws DBException, DataAccessException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectProductByID(pid);
	}
	
	public void removeProduct(int pid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		this.productDAO.deleteProduct(pid);
	}
	
	public void editProduct(Product product) throws DBException, InsertFailedException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		this.productDAO.updateProduct(product);
	}
	
	public void saveProduct(Product product) throws DBException, InsertFailedException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		this.productDAO.addProduct(product);
	}

}
