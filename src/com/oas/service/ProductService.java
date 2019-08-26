package com.oas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.oas.dao.BidDAO;
import com.oas.dao.CategoryDAO;
import com.oas.dao.ProductDAO;
import com.oas.dao.UserDAO;
import com.oas.exception.DBException;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Bid;
import com.oas.model.Category;
import com.oas.model.Product;
import com.oas.model.User;
import com.oas.util.DBUtil;

/*
 * Service class made to call all the DAO functions
 */

public class ProductService {
	

	/*
	 * Objects created for each DAO required to get access of its functions.
	 */
	
	UserDAO userDAO = new UserDAO();
	BidDAO bidDAO = new BidDAO();
	ProductDAO productDAO = new ProductDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	
	// Category-----------------------------------------------------------------------
	
	/*
	 * Calling selectAllByCategory() function from CategoryDAO class 
	 */
	
	public List<Category> listAllByCategory() throws DBException, DataAccessException {
		DBUtil.open();
		this.CategoryDAO.setConnection(DBUtil.getConnection());
		return this.CategoryDAO.selectAllByCategory();
	}
	
	// Bid-------------------------------------------------------------------------------
	
	/*
	 * Calling selectAllBids() function from bidDAO class 
	 */
	
	public List<Bid> listAllBids() throws DBException, DataAccessException {
		DBUtil.open();
		this.bidDAO.setConnection(DBUtil.getConnection());
		return this.bidDAO.selectAllBids();
	}
	
	// User--------------------------------------------------------------------
	
	/*
	 * Calling selectAllUsers() function from userDAO class 
	 */
	
	public List<User> listAllUsers() throws DBException, DataAccessException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectAllUsers();
	}

	/*
	 * Calling selectUserByID() function from userDAO class 
	 * Passing userID of User as a parameter 
	 */
	
	public User listUserByID(int id) throws DBException, DataAccessException {
		DBUtil.open();
		this.userDAO.setConnection(DBUtil.getConnection());
		return this.userDAO.selectUserByID(id);
	}
	
	// Product-----------------------------------------------------------------------
	
	/*
	 * Calling selectAllProducts() function from productDAO class 
	 */
	
	public List<Product> listAllProduct() throws DBException, DataAccessException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectAllProducts();
	}

	/*
	 * Calling selectProductByID() function from productDAO class 
	 * Passing productID of Product as a parameter 
	 */
	
	public Product listProductByID(int pid) throws DBException, DataAccessException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		return this.productDAO.selectProductByID(pid);
	}
	
	/*
	 * Calling deleteProduct() function from productDAO class 
	 * Passing productID of Product as a parameter 
	 */
	
	public void removeProduct(int pid) throws DBException, InsertFailedException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		this.productDAO.deleteProduct(pid);
	}
	
	/*
	 * Calling updateProduct() function from productDAO class 
	 * Passing object of Product as a parameter 
	 */
	
	public void editProduct(Product product) throws DBException, InsertFailedException {
		DBUtil.open();
		this.productDAO.setConnection(DBUtil.getConnection());
		this.productDAO.updateProduct(product);
	}
	
	/*
	 * Calling addProduct() function from productDAO class 
	 * Passing object of Product as a parameter 
	 */
	
	public boolean saveProduct(String productName,String category,String description,String actualPrice,String quantity,String image) throws DBException, InsertFailedException {
	if(validation.checkString(request.getParameter("productName"))&&validation.checkString(request.getParameter("category"))&&
	validation.checkString(request.getParameter("description"))&&validation.checkInt(request.getParameter("quantity"))&&
	validation.checkDouble(request.getParameter("actualPrice"))&&validation.checkString(request.getParameter("image"))){
		Product product = new Product();
		product.setName(request.getParameter("productName"));
		product.setCategory(request.getParameter("category"));
		product.setDescription(request.getParameter("description"));
		product.setActualPrice(request.getParameter("actualPrice"));
		product.setQuantity(request.getParameter("quantity"));
		product.setImage(request.getParameter("image"));

		DBUtil.open();
			this.userDAO.setConnection(DBUtil.getConnection());

			try {
				DBUtil.beginTx();
				this.userDAO.addUser(user);
				DBUtil.commitTx();
				return true;

			} catch (SQLException e) {
				System.out.println("Transaction is being rolled back due to SQLException!");
				DBUtil.rollbackTx();
				return false;
			}

		}else{
			return false;
		}
	}

}

