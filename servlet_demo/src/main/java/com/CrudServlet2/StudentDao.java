package com.CrudServlet2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class StudentDao {
	
	
	private static Connection getconnection() {
		Connection con=null;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
	con = 	DriverManager.getConnection("jdbc:mysql://192.168.1.116:3306/training","admin","newpwd");
		
		
	
		
		
	
		}
		catch(Exception e) {System.out.println(e);}
	
		return con;
	}
	
	
	public static int insert(StudentBean sb) {
		
		int status=0;
		//boolean already = false;
	
		try {
	Connection con = StudentDao.getconnection();
		
	
	
	PreparedStatement ps = con.prepareStatement(
				
				"Insert into register(id,roll_no,name,password)values(?,?,?,?)"
				);
	
	//StudentBean sb = new StudentBean();
	
	ps.setInt(1,sb.getId() );
	ps.setInt(2, sb.getRoll_no());
	ps.setString(3,sb.getName());
	ps.setString(4,sb.getPassword());
	
	
	
	status =  ps.executeUpdate();
	
		
		}catch(SQLIntegrityConstraintViolationException e) {
			
			//already = true;
			status = -1;
			System.out.println(e);
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return status;
	}


	public static boolean authantication(StudentBean sb) {
		
		boolean auth = false;
		ResultSet rs = null;
		
		try {
			Connection con = StudentDao.getconnection();
			
			PreparedStatement ps = con.prepareStatement("select * from register where name=? and password=?");
			
		//	System.out.println(sb.getName());
			ps.setString(1,sb.getName());
			ps.setString(2, sb.getPassword());
			
			rs = ps.executeQuery(); 
			auth = rs.next();
		//	System.out.println(rs.getString("id"));
			//System.out.println(rs.getString("password"));
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return auth;
		
	}
	
	public static List<StudentBean> view() {
		
		List<StudentBean> students = new ArrayList<StudentBean>();
		
		try {
		
		Connection con = getconnection();
		
		PreparedStatement ps = con.prepareStatement("select * from register");
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		rs.next();
		while(rs.next()) {
			
			int id = rs.getInt("id");
			int rollno=rs.getInt("roll_no");
			String name = rs.getString("name");
			String password = rs.getString("password");
		
			StudentBean sb = new StudentBean(id,rollno,name,password);
			students.add(sb);
			
		}
		
		
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return students;
		
	}

	

}
