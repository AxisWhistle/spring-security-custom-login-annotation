package com.mkyong.web.model;

import java.util.Date;

public class User {

	private String username;
	private String password;
	private int age;
	private Date birthDay;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, int age, Date birthDay) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.birthDay = birthDay;
	}
}
