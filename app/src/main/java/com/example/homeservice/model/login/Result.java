package com.example.homeservice.model.login;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("address")
	private String address;

	@SerializedName("name")
	private String name;

	@SerializedName("userType")
	private String userType;

	@SerializedName("userId")
	private int userId;

	@SerializedName("phoneNo")
	private String phoneNo;

	@SerializedName("username")
	private String username;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}