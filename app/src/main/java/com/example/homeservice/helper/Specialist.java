package com.example.homeservice.helper;

public class Specialist {
    int image;
    String rating, title, descriptions;

    public Specialist(int image, String rating, String title, String descriptions) {
        this.image = image;
        this.rating = rating;
        this.title = title;
        this.descriptions = descriptions;
    }

    public int getImage() {
        return image;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
    public String getDescriptions() {
        return descriptions;
    }
}
