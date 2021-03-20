package com.example.homeservice.service;

import com.example.homeservice.model.OfferModel;

import java.util.ArrayList;

public class OfferService {
    public static ArrayList<OfferModel> offers = new ArrayList<>();

    public static void addOffer(OfferModel offer) {
        offers.add(offer);
    }
}
