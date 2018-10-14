package com.example.vanshika.concetto.Models;

public class GuestLecture {
    private String lecture_name, guest_name, date,time,about;
    int image;

    public GuestLecture(String lecture_name, String guest_name, String date, String time, String about, int image) {
        this.lecture_name = lecture_name;
        this.guest_name = guest_name;
        this.date = date;
        this.time = time;
        this.about = about;
        this.image = image;
    }

    public GuestLecture(String lecture_name, String guest_name, String date, String time, String about) {

        this.lecture_name = lecture_name;
        this.guest_name = guest_name;
        this.date = date;
        this.time = time;
        this.about = about;
    }

    public GuestLecture() {
    }

    public GuestLecture(String lecture_name, String guest_name, String date, String time) {
        this.lecture_name = lecture_name;
        this.guest_name = guest_name;
        this.date = date;
        this.time = time;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
