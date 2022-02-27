package com.example.firstfour;

public class MoreCourses {
    String Name;
    String Rating;
    String Date;
    String image_url;

    public MoreCourses() {
    }

    public MoreCourses(String name, String rating, String date, String image_url) {
        Name = name;
        Rating = rating;
        Date = date;
        this.image_url = image_url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
