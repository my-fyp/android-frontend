
package com.example.homeservice.model.bookingreq;

import com.google.gson.annotations.SerializedName;

public class BookingRequest {

    @SerializedName("bookedBy")
    private String mBookedBy;
    @SerializedName("completedStatus")
    private Boolean mCompletedStatus;
    @SerializedName("customerId")
    private Long mCustomerId;
    @SerializedName("discount")
    private Long mDiscount;
    @SerializedName("paidStatus")
    private Boolean mPaidStatus;
    @SerializedName("problemDescription")
    private String mProblemDescription;
    @SerializedName("serviceDate")
    private String mServiceDate;
    @SerializedName("serviceType")
    private String mServiceType;
    @SerializedName("totalPrice")
    private Long mTotalPrice;
    @SerializedName("vendorId")
    private Long mVendorId;
    @SerializedName("serviceAddress")
    private Long serviceAddress;

    public String getBookedBy() {
        return mBookedBy;
    }

    public void setBookedBy(String bookedBy) {
        mBookedBy = bookedBy;
    }

    public Boolean getCompletedStatus() {
        return mCompletedStatus;
    }

    public void setCompletedStatus(Boolean completedStatus) {
        mCompletedStatus = completedStatus;
    }

    public Long getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(Long customerId) {
        mCustomerId = customerId;
    }

    public Long getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Long discount) {
        mDiscount = discount;
    }

    public Boolean getPaidStatus() {
        return mPaidStatus;
    }

    public void setPaidStatus(Boolean paidStatus) {
        mPaidStatus = paidStatus;
    }

    public String getProblemDescription() {
        return mProblemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        mProblemDescription = problemDescription;
    }

    public String getServiceDate() {
        return mServiceDate;
    }

    public void setServiceDate(String serviceDate) {
        mServiceDate = serviceDate;
    }

    public String getServiceType() {
        return mServiceType;
    }

    public void setServiceType(String serviceType) {
        mServiceType = serviceType;
    }

    public Long getTotalPrice() {
        return mTotalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        mTotalPrice = totalPrice;
    }

    public Long getVendorId() {
        return mVendorId;
    }

    public void setVendorId(Long vendorId) {
        mVendorId = vendorId;
    }

    public Long getServiceAddress() {
        return serviceAddress;
    }

}
