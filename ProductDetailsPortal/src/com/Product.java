package com;

public class Product {

	private String prodname;
	private int quantity;
	private Double price;
	

	
	public Product() {
		super();
	
	}

	@Override
	public String toString() {
		return "Product [prodname=" + prodname + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
}
