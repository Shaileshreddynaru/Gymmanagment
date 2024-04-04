package com.Myproject.PowerGym.models;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	@NotEmpty(message="Required")
	private String username;
	@NotEmpty(message="Required")
	private int age;
	@NotEmpty(message="Required")
	private String gender;
	@NotEmpty(message="Required")
	private String mobileNumber;
	@NotEmpty(message="Required")
	private String choose;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	
	
}
