package com.example.vanshika.concetto.Models;

public class GuestLecture {
    private String LectureName, GuestName, image,time;

    public GuestLecture(String lectureName, String guestName, String image, String time) {
        LectureName = lectureName;
        GuestName = guestName;
        this.image = image;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLectureName() {
        return LectureName;
    }

    public void setLectureName(String lectureName) {
        LectureName = lectureName;
    }

    public String getGuestName() {
        return GuestName;
    }

    public void setGuestName(String guestName) {
        GuestName = guestName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
