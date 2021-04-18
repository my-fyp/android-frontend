package com.example.homeservice.model.problem;

import com.google.gson.annotations.SerializedName;

public class ProblemResponse{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("customerId")
	private int customerId;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("problemImage")
	private String problemImage;

	@SerializedName("profileImage")
	private String profileImage;

	@SerializedName("problemId")
	private int problemId;

	@SerializedName("phoneNo")
	private String phoneNo;

	public String getCreatedAt(){
		return createdAt;
	}

	public int getCustomerId(){
		return customerId;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public String getProblemImage(){
		return problemImage;
	}

	public String getProfileImage(){
		return profileImage;
	}

	public int getProblemId(){
		return problemId;
	}

	public String getPhoneNo(){
		return phoneNo;
	}
}