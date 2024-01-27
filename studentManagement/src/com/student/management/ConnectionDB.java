package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	static Connection con;
	
	public static Connection createConnection() {
	    try {
//	    	Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "$Kunal_25");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
