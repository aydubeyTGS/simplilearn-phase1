package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.beans.TravelBean;
import com.beans.User;


public class AppDao {
	
	private static AppDao appDao ;
	
	public static AppDao getAppDaoObj() {
		if(appDao!=null) {
			return appDao;
		}else {
			appDao = new AppDao();
			return appDao;
		}

	}

	public List<TravelBean> availableFlight(String source,String destination,String date,String person) {
		System.out.println("AppDao ----availableFlight");
		TravelBean travel = null;
		List<TravelBean> travels = new ArrayList<>();
		 Connection conn = DBConnection.getConnectionToDatabase();
		 System.out.println("Connection Obj :"+conn);
		try {

			String sql = "select * from travel where isactive=true and source = '"+source+"' and destination = '"+destination+"';";

			System.out.println("Sql : "+sql);
			Statement statement = conn.createStatement();

			ResultSet set = statement.executeQuery(sql);

			while (set.next()) {
				travel = new TravelBean();
				travel.setFlightId(set.getInt("flightid"));
				travel.setCompany(set.getString("company").toUpperCase());
				travel.setFare(set.getDouble("fare"));
				travels.add(travel);

			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return travels;
	}
	public List<TravelBean> availableAllFlight() {
		System.out.println("AppDao ----availableAllFlight");
		TravelBean travel = null;
		List<TravelBean> travels = new ArrayList<>();
		Connection conn = DBConnection.getConnectionToDatabase();
		System.out.println("Connection Obj :"+conn);
		try {
			
			String sql = "select * from travel where isactive=true ;";
			
			System.out.println("Sql : "+sql);
			Statement statement = conn.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			
			while (set.next()) {
				travel = new TravelBean();
				travel.setFlightId(set.getInt("flightid"));
				travel.setCompany(set.getString("company").toUpperCase());
				travel.setFare(set.getDouble("fare"));
				travel.setSource(set.getString("source"));
				travel.setDestination(set.getString("destination"));
				travels.add(travel);
				
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return travels;
	}
	
	public TravelBean getFlight(String flightId) {
		System.out.println("AppDao ----getFlight");
		TravelBean travel = null;
		Connection conn = DBConnection.getConnectionToDatabase();
		System.out.println("Connection Obj :"+conn);
		try {
			
			String sql = "select * from travel where flightid ='"+flightId+"';";
			
			System.out.println("Sql : "+sql);
			Statement statement = conn.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			
			if (set.next()) {
				travel = new TravelBean();
				travel.setFlightId(set.getInt("flightid"));
				travel.setCompany(set.getString("company").toUpperCase());
				travel.setFare(set.getDouble("fare"));
				
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return travel;
	}
	
	public TravelBean getSourceDest(String flightId) {
		System.out.println("AppDao ----getFlight");
		TravelBean travel = null;
		Connection conn = DBConnection.getConnectionToDatabase();
		System.out.println("Connection Obj :"+conn);
		try {
			
			String sql = "select source,destination from travel where flightid ='"+flightId+"';";
			
			System.out.println("Sql : "+sql);
			Statement statement = conn.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			
			if (set.next()) {
				travel = new TravelBean();
				travel.setSource(set.getString("source").toUpperCase());
				travel.setDestination(set.getString("destination"));
				
				
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return travel;
	}

	public int registerUser(User user) {
		int rowsAffected = 0;
		
				try {
					// get the connection for the database
					Connection connection = DBConnection.getConnectionToDatabase();
					System.out.println("******username :"+user.getUsername());
		
					// write the insert query
					String insertQuery = "insert into users (firstname,type,username,password) values (?,?,?,?)";
		
					// set parameters with PreparedStatement
					java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
					statement.setString(1, user.getName());
					statement.setString(2, user.getType());
					statement.setString(3, user.getUsername());
//					statement.setString(4, user.getLastName());
					statement.setString(4, user.getPassword());
		
					// execute the statement
					rowsAffected = statement.executeUpdate();
		
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
				return rowsAffected;
	}
	
	public int changePwd(String userId,String currentPwd,String newPwd) {
		int rowsAffected = 0;
		
		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// write the insert query
			String insertQuery = "update users set password = ? where username = ? and password = ?";
			
			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, newPwd);
			statement.setString(2, userId);
			statement.setString(3, currentPwd);
			
			// execute the statement
			rowsAffected = statement.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}

	public User validUser(String username, String password) {
		boolean isValidUser = false;
		User user = null;
		try {

			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the select query
			String sql = "select * from users where username=? and password=?";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			// execute the statement and check whether user exists

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				user = new User();
				user.setName(set.getString("firstname"));
				user.setType(set.getString("type"));
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				isValidUser = true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return user;
	}


}
