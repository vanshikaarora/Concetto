package com.example.vanshika.concetto.Models;

/**
 * Created by Shridhar on 27-Sep-18.
 */

public class Event {

    private String name, date, time;

    public Event(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
