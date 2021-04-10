package com.ecom.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ecom {
	
	public Ecom() {
		
	}
	public Ecom(int aid, String pname, int quantity, double price) {
		super();
		this.aid = aid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}
	@Id
private int aid;
private String pname;
private int quantity;
private double price;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getApname() {
	return pname;
}
public void setApname(String pname) {
	this.pname = pname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Ecom [aid=" + aid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + "]";
}



}
