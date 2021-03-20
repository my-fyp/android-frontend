package com.example.homeservice.model;

public class ProblemModel {
    private String vendorName;
    private int vendorImage;
    private String contact;

    private int offerImage;
    private String offerDescription;
    private String offerPostedDate;
    private String offerValidDate;

    public ProblemModel(String vendorName, int vendorImage, String contact, int offerImage, String offerDescription, String offerPostedDate, String offerValidDate) {
        this.vendorName = vendorName;
        this.vendorImage = vendorImage;
        this.contact = contact;
        this.offerImage = offerImage;
        this.offerDescription = offerDescription;
        this.offerPostedDate = offerPostedDate;
        this.offerValidDate = offerValidDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorImage() {
        return vendorImage;
    }

    public void setVendorImage(int vendorImage) {
        this.vendorImage = vendorImage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferPostedDate() {
        return offerPostedDate;
    }

    public void setOfferPostedDate(String offerPostedDate) {
        this.offerPostedDate = offerPostedDate;
    }

    public String getOfferValidDate() {
        return offerValidDate;
    }

    public void setOfferValidDate(String offerValidDate) {
        this.offerValidDate = offerValidDate;
    }
}
