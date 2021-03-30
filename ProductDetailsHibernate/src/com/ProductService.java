package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.DBConnection;

public class ProductService {

	public Product checkForId(int id)
	{
		Product prod=null;
		try {
			Connection conn=DBConnection.getConnectionToDatabase();
			
			String sql = "select * from Product where pid="+id;
	//		String sql = "select * from Product where pid=? ";
//			System.out.println(conn);
			PreparedStatement st = conn.prepareStatement(sql);
//			Statement st = conn.createStatement();
//			st.setInt(1, id);
			
			

			// execute query, get resultset and return User info
			ResultSet set = st.executeQuery();
			while (set.next()) {
				prod=new Product();
				prod.setId(set.getInt("pid"));
				prod.setProdname(set.getString("pname"));
				prod.setQuantity(set.getInt("pquant"));
				prod.setPrice(set.getDouble("pprice"));
				
			} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println("*****************");
		System.out.println(prod);
		System.out.println("*****************");
		return prod;
	}
}
