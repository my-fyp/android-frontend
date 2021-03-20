package com.example.homeservice.service;

import java.util.ArrayList;

import com.example.homeservice.model.NotificationModel;

public class NotificationService {
    public static ArrayList<NotificationModel> notifications = new ArrayList<>();

    public static void addNotification(NotificationModel notification) {
        notifications.add(notification);
    }
}
