package com.CrudServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
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
	

	public static void delete(String id) {
		
		
		try {
			Connection con = getconnection();
			PreparedStatement ps = con.prepareStatement("delete from user9 where id=?");
			ps.setString(1, id);
			ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		
	}
	
	public static List<EmpPojo> view() {
		
		List<EmpPojo> employee = new ArrayList<EmpPojo>();

		try {
			Connection con = getconnection();
			PreparedStatement ps = con.prepareStatement("select * from user9");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{    
				String i = rs.getString("id");
				String name = rs.getString("name");
				String password= rs.getString("password");
				String email = rs.getString("email");
				String country = rs.getString("country");
				
				int id = Integer.parseInt(i);
				EmpPojo ep = new EmpPojo(id, name, email, password, country);
				employee.add(ep);
				
			}
			
			
		}catch(Exception l) {
			
			System.out.println(l);
			
		}
		return employee;

	}
	
public static int edit(EmpPojo e) {
	int state = 0;
	
	try {
		Connection con =getconnection();
		PreparedStatement ps = con.prepareStatement("update  user9 set name=? , password=? , email=? , country=? where id=?");
		ps.setString(1,e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3,e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setInt(5, e.getId());
		
		ps.executeUpdate();
		
	}catch(Exception k) {
		
		
	}
	
	
	return state;
	
	
}
	
	
}
