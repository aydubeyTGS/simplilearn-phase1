package com.dao;

import java.sql.*;

public class DBConnection{
	
	private static Connection connection;
	public static void main(String[] args)
	{
		System.out.println(getConnectionToDatabase());
	}
	
	static {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysqljdbc Driver Registered");
			
			//get hold of the Driver manager
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline",
					"admin","1234");			
		}
		catch(ClassNotFoundException e) {
			System.out.println("where is your mysql jdbc driver");
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			System.out.println("connectin failed! check output console");
			e.printStackTrace();
		}
		if(connection!=null)
		{
			System.out.println("connection made to database");
		}
	}
	public static Connection getConnectionToDatabase() {
		return connection;
		
	}
}