package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static int rowsAffected;
	public static boolean insertStudentInDB(Student st) {
		boolean f = false;
		try {
			Connection con = ConnectionDB.createConnection();
			
			String q = "Insert into students(roll_no, name, phone) values(?,?,?)";
			short c = 0;
			
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(++c, st.getRollNo());
			pstmt.setString(++c, st.getName());
			pstmt.setLong(++c, st.getPhone());
			
			rowsAffected = pstmt.executeUpdate();
			
			if(rowsAffected > 0) f = true;
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public static boolean deleteStudentFromDB(int rollNo) {
		boolean f = false;
		try {
			Connection con = ConnectionDB.createConnection();
			
			String q = "DELETE FROM students where roll_no=?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, rollNo);
			
			pstmt.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public static void showAllStudents() {

		try {
			Connection con = ConnectionDB.createConnection();
			
			String q = "SELECT * FROM STUDENTS";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			int i = 1;
			
			while(set.next()) {
				int rollNo = set.getInt("roll_no");
				String name = set.getString("name");
				long phone = set.getLong(3);
				
				System.out.println("Details of Student " + i++);
				System.out.println("Roll No -> " + rollNo);
				System.out.println("Name -> " + name);
				System.out.println("phone No. -> " + phone);
				System.out.println();
				
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean updateStudent(int rollNo, long newPhone) {
		boolean f = false;
		try {
			Connection con = ConnectionDB.createConnection();
			
//			String q = "UPDATE STUDENTS SET phone=? WHERE roll_no=?";
//			PreparedStatement pstmt = con.prepareStatement(q);
//			pstmt.setLong(1, newPhone);
//			pstmt.setInt(2, rollNo);
//			 ***********************************or*************************************
			
			String q = String.format("UPDATE STUDENTS SET phone=%d WHERE roll_no=%d", newPhone, rollNo);
			PreparedStatement pstmt = con.prepareStatement(q);
			
			rowsAffected =  pstmt.executeUpdate();
			
			System.out.println(rowsAffected);
						
			if(rowsAffected > 0) f = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return f;
	}
	public static boolean addMultipleStudentsWithBatchProcessing(Student students[]) {
		boolean f = false;
		try {
			Connection con = ConnectionDB.createConnection();
			String q = "Insert into students(roll_no, name, phone) values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);	
			short c;
			for(Student st: students) {
				if(st != null) {
				    c = 1;
				
					pstmt.setInt(c++, st.getRollNo());
					pstmt.setString(c++, st.getName());
					pstmt.setLong(c++, st.getPhone());
					
					pstmt.addBatch();
				}
				c = 1;
			}
			
			int[] result = pstmt.executeBatch();
			if(result.length > 0) f = true;
			for(int i = 0; i < result.length; i++) {
				if(result[i] == 0) {
					f = false;
					System.out.println("query " + i + "is not executed successfully");
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
}
