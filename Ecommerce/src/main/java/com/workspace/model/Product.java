package com.workspace.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Primary;


@Entity
@Primary
public class Product {
	@Id
	private int pid;
	private String pname;
	private int quantity;
    private Date date;
    private String category;
    

	public Product() {
		
	}
	
	public Product(int pid, String pname, int quantity, Date date,String category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.date = date;
		this.category=category;
	}
	

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return String.format("pid=%s, pname=%s, quantity=%s, date=%s, category=%s<br><br>", pid, pname, quantity,
				date, category);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    
    
}
