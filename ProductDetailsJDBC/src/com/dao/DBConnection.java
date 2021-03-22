package com.dao;

import java.sql.*;

public class DBConnection{
	public static void main(String[] args) {
		System.out.println(getConnectionToDatabase());
	}
	public static Connection getConnectionToDatabase() {
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("oracle jdbc Driver Registered");
			
			//get hold of the Driver manager
			
			connection=DriverManager.getConnection("jdbc:oracle:thin:root@//LAPTOP-24VISA1M:1521/xe",
					"root","admin");			
		}
		catch(ClassNotFoundException e) {
			System.out.println("where is your oracle jdbc driver");
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
		return connection;
		
	}
}