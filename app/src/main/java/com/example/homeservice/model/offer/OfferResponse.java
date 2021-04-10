package com.example.homeservice.model.offer;

import com.google.gson.annotations.SerializedName;

public class OfferResponse{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("offerImage")
	private String offerImage;

	@SerializedName("validDate")
	private String validDate;

	@SerializedName("name")
	private String name;

	@SerializedName("offerId")
	private int offerId;

	@SerializedName("description")
	private String description;

	@SerializedName("vendorId")
	private int vendorId;

	@SerializedName("profileImage")
	private Object profileImage;

	@SerializedName("phoneNo")
	private String phoneNo;

	public String getCreatedAt(){
		return createdAt;
	}

	public String getOfferImage(){
		return offerImage;
	}

	public String getValidDate(){
		return validDate;
	}

	public String getName(){
		return name;
	}

	public int getOfferId(){
		return offerId;
	}

	public String getDescription(){
		return description;
	}

	public int getVendorId(){
		return vendorId;
	}

	public Object getProfileImage(){
		return profileImage;
	}

	public String getPhoneNo(){
		return phoneNo;
	}
}