package com.oas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oas.exception.DataAccessException;
import com.oas.exception.InsertFailedException;
import com.oas.model.Category;

public class CategoryDAO {
	Connection connection = null;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void saveCategory(Category category) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO CATEGORY_MASTER( CATEGORY_NAME, DESCRIPTION) VALUES(?,?)");
			
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getDescription());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not save in CATEGORY_MASTER table");

		}
	}
	
	public void updateCategory(Category category) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("UPDATE CATEGORY_MASTER SET CATEGORY_NAME=?, DESCRIPTION=? WHERE CATEGORY_ID=?");
			
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getDescription());
			preparedStatement.setInt(2, category.getCategoryID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not update CATEGORY_MASTER table");

		}
	}
	
	public void removeCategory(int cid) throws InsertFailedException {
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = this.connection
					.prepareStatement("DELETE FROM CATEGORY_MASTER WHERE CATEGORY_ID=?");
			preparedStatement.setInt(1, cid);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertFailedException("Could not delete record from CATEGORY_MASTER table");

		}
	}
	
	public List<Category> selectAllCategories() throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Category> categories = new ArrayList<>();

		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM CATEGORY_MASTER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Category category= new Category();
				category.setCategoryID(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));
				
				categories.add(category);
			}
			return categories;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from CATEGORY_MASTER table");
		}

	}

	public Category selectCategoryByID(int pid) throws DataAccessException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = this.connection.prepareStatement("SELECT * FROM CATEGORY_MASTER WHERE PRODUCT_ID=?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			Category category= new Category();
			while (resultSet.next()) {
				
				category.setCategoryID(resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));
				
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("could not access records from CATEGORY_MASTER table");
		}

	}


}
