package com.oas.model;

public class Product {
	
	int productID;
	String name;
	int catgory;
	String description;
	double actualPrice;
	int quantity;
	int sellerID;

	public Product() {
		
	}

	public Product(int productID, String name, int catgory, String description, double actualPrice, int quantity,
			int sellerID) {
		this.productID = productID;
		this.name = name;
		this.catgory = catgory;
		this.description = description;
		this.actualPrice = actualPrice;
		this.quantity = quantity;
		this.sellerID = sellerID;
	}
	
	public Product(String name, int catgory, String description, double actualPrice, int quantity,
			int sellerID) {
		this.name = name;
		this.catgory = catgory;
		this.description = description;
		this.actualPrice = actualPrice;
		this.quantity = quantity;
		this.sellerID = sellerID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatgory() {
		return catgory;
	}

	public void setCatgory(int catgory) {
		this.catgory = catgory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	
	
}
