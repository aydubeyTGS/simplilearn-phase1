package com.workspace.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String role;
	@Id
	private String username;
	private String password;
	
	public User() {
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String role, String username, String password) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("role=%s, username=%s, password=%s <br><br>", role, username, password);
	}
	

}
