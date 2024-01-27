package com.student.management;

public class Student {
	private int sid;
	private int rollNo;
	private String name;
	private String city;
	private long phone;
	public Student(int rollNo, String name, String city, long phone) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.city = city;
		this.phone = phone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", rollNo=" + rollNo + ", name=" + name + ", city=" + city + ", phone=" + phone
				+ "]";
	}

}
