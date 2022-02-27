package com.example.firstfour;

public class nav_layouts {
    String Title;
    String Author;
    String Rating;
    String image_url;

    public nav_layouts() {
    }

    public nav_layouts(String title, String author, String rating, String image_url) {
        Title = title;
        Author = author;
        Rating = rating;
        this.image_url = image_url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
