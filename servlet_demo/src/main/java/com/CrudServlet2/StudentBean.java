package com.CrudServlet2;


public class StudentBean {
private int id,roll_no;
private String name;
private static String collage;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRoll_no() {
	return roll_no;
}
public void setRoll_no(int roll_no) {
	this.roll_no = roll_no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public static String getCollage() {
	return collage;
}
public static void setCollage(String collage) {
	StudentBean.collage = collage;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




public StudentBean(int id, int roll_no, String name, String password) {
	super();
	this.id = id;
	this.roll_no = roll_no;
	this.name = name;
	this.password = password;
}
public StudentBean() {
	super();
}
@Override
public String toString() {
	return "StudentBean [id=" + id + ", roll_no=" + roll_no + ", name=" + name + ", password=" + password + "]";
}



	
	
}
