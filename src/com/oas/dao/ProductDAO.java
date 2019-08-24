package com.oas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Product;


public class ProductDAO {
	
	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void saveProduct(Product product) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO PRODUCT_MASTER( PRODUCT_NAME, CATEGORY_ID, DESCRIPTION, PRICE, QUANTITY, SELLER_ID) VALUES(?,?,?,?,?,?)");
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getCatgory());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getActualPrice());
			preparedStatement.setInt(5, product.getQuantity());
			preparedStatement.setInt(6, product.getSellerID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not save in PRODUCT_MASTER table");

		}
	}
	
	public void updateProduct(Product product) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("UPDATE PRODUCT_MASTER SET PRODUCT_NAME=?, CATEGORY_ID=?, DESCRIPTION=?, PRICE=?, QUANTITY=?, SELLER_ID=? WHERE PRODUCT_ID=?");
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getCatgory());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getActualPrice());
			preparedStatement.setInt(5, product.getQuantity());
			preparedStatement.setInt(6, product.getSellerID());
			preparedStatement.setInt(7, product.getProductID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not update PRODUCT_MASTER table");

		}
	}
	
	public void removeProduct(int pid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("DELETE FROM PRODUCT_MASTER WHERE PRODUCT_ID=?");
			preparedStatement.setInt(1, pid);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not delete record from PRODUCT_MASTER table");

		}
	}
	
	public List<Product> selectAllProducts() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Product> products = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM PRODUCT_MASTER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product= new Product();
				product.setProductID(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setCatgory(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				product.setActualPrice(resultSet.getDouble(5));
				product.setQuantity(resultSet.getInt(6));
				product.setSellerID(resultSet.getInt(7));
				
				products.add(product);

			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from PRODUCT_MASTER table");
		}

	}

	public Product selectProductByID(int pid) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Product product = new Product();
		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM PRODUCT_MASTER WHERE PRODUCT_ID=?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				product.setProductID(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setCatgory(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				product.setActualPrice(resultSet.getDouble(5));
				product.setQuantity(resultSet.getInt(6));
				product.setSellerID(resultSet.getInt(7));
				
			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from PRODUCT_MASTER table");
		}

	}


}
