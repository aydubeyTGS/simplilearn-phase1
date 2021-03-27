package com.beans;

public class User {
	private String name;
	private String username;
	private String password ;
	private String type;
	private String gender;
	private String mobile;
	public User(String name, String username, String password, String type, String gender, String mobile) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.type = type;
		this.gender = gender;
		this.mobile = mobile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", gender=" + gender + ", mobile=" + mobile + "]";
	}
	
	
	
}
