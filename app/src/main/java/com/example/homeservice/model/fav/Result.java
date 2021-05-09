package com.example.homeservice.model.fav;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("favouriteId")
	private int favouriteId;

	@SerializedName("vendor")
	private Object vendor;

	@SerializedName("customerId")
	private int customerId;

	@SerializedName("vendorId")
	private int vendorId;

	@SerializedName("customer")
	private Object customer;

	public String getCreatedAt(){
		return createdAt;
	}

	public int getFavouriteId(){
		return favouriteId;
	}

	public Object getVendor(){
		return vendor;
	}

	public int getCustomerId(){
		return customerId;
	}

	public int getVendorId(){
		return vendorId;
	}

	public Object getCustomer(){
		return customer;
	}
}