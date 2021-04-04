package com.example.homeservice.model;

import java.util.Date;

public class BookingModel {
    private int bookingId;
    private Date bookingDate;
    private Date serviceDate;

    private int problemDescription;
    private String serviceType;
    private int totalPrice;
    private boolean completedStatus;
    private boolean paidStatus;


    public BookingModel(int bookingId, Date bookingDate, Date serviceDate, int problemDescription, String serviceType, int totalPrice, boolean completedStatus, boolean paidStatus) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.problemDescription = problemDescription;
        this.serviceType = serviceType;
        this.totalPrice = totalPrice;
        this.completedStatus = completedStatus;
        this.paidStatus = paidStatus;

    }


    public void getBookingDescription() {
    }
}
