package com.example.homeservice.model;

public class FavouriteModel {
    private int FavouriteId;
    private int UserId;
    private int VendorId;

    public FavouriteModel(int favouriteId, int userId, int vendorId) {
        FavouriteId = favouriteId;
        UserId = userId;
        VendorId = vendorId;
    }

    public int getFavouriteId() {
        return FavouriteId;
    }

    public int getUserId() {
        return UserId;
    }

    public int getVendorId() {
        return VendorId;
    }
}
