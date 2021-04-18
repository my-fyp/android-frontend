package com.example.homeservice.model.bookingreq;

import com.google.gson.annotations.SerializedName;

public class BookingResponse {

    @SerializedName("serviceType")
    private String serviceType;

    @SerializedName("serviceDate")
    private String serviceDate;

    @SerializedName("vendorImage")
    private String vendorImage;

    @SerializedName("problemDescription")
    private String problemDescription;

    @SerializedName("vendorId")
    private int vendorId;

    @SerializedName("vendorContact")
    private String vendorContact;

    @SerializedName("vendorName")
    private String vendorName;

    @SerializedName("bookingId")
    private int bookingId;

    @SerializedName("customerName")
    private String customerName;

    @SerializedName("customerContact")
    private String customerContact;

    @SerializedName("isAccepted")
    private boolean isAccepted;

    @SerializedName("customerId")
    private int customerId;

    @SerializedName("bookingDate")
    private String bookingDate;

    @SerializedName("bookedBy")
    private String bookedBy;

    @SerializedName("customerImage")
    private String customerImage;


    @SerializedName("serviceAddress")
    private String serviceAddress;

    public String getServiceType() {
        return serviceType;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public String getVendorImage() {
        return vendorImage;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getVendorContact() {
        return vendorContact;
    }

    public String getVendorName() {
        return vendorName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public String getCustomerImage() {
        return customerImage;
    }
}