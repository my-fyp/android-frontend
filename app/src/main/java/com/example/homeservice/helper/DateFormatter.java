package com.example.homeservice.helper;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class DateFormatter {
    public static String formatDate(String myDate, String myDateFormat) {
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date;
            try {
                date = sdf.parse(myDate);
            } catch (Exception ex) {
                return null;
            }
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf2 = new SimpleDateFormat(myDateFormat);
            assert date != null;
            return sdf2.format(date);
        } catch (Exception ex) {
            return "Unknown date";
        }
    }
}
