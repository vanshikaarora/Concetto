package com.example.vanshika.concetto.Models;

/**
 * Created by shridhar on 27-Sep-18.
 */

public class Event {

    private String name, image;

    public Event(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
