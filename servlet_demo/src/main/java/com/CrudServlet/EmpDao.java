package com.CrudServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class EmpDao {

	public static Connection getconnection() {
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.116:3306/training","admin","newpwd");
			
			if(con.isClosed()) {
				System.out.println("notconnected");
				
			}else {
				System.out.println("connected");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return con;
	}
	
	public static int save(EmpPojo e) {
		int status =0;
		
		try {
			Connection con = EmpDao.getconnection();
			PreparedStatement ps = con.prepareStatement("insert into user9(name,password,email,country)values(?,?,?,?)");
			
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			
			status = ps.executeUpdate();
			
			con.close();
			
			
		}catch(Exception k) {
			System.out.println(e);
		}
		
		return status;
	}
	

	
	
	
}
