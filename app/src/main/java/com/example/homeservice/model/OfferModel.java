package com.example.homeservice.model;

public class OfferModel {
    private String vendorName;
    private String vendorImage;
    private String contact;

    private String offerImage;
    private String offerDescription;
    private String offerPostedDate;
    private String offerValidDate;

    public OfferModel(String vendorName, String vendorImage, String contact, String offerImage, String offerDescription, String offerPostedDate, String offerValidDate) {
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

    public String getVendorImage() {
        return vendorImage;
    }

    public void setVendorImage(String vendorImage) {
        this.vendorImage = vendorImage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
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
