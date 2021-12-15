package com.techelevator.model;

import java.sql.Time;
import java.time.LocalTime;

public class Landmark {
    private long id;
    private String name;
    private String category;
    private String address;
    private float latitude;
    private float longitude;
    private Time sundayOpen;
    private Time sundayClose;
    private Time mondayOpen;
    private Time mondayClose;
    private Time tuesdayOpen;
    private Time tuesdayClose;
    private Time wednesdayOpen;
    private Time wednesdayClose;
    private Time thursdayOpen;
    private Time thursdayClose;
    private Time fridayOpen;
    private Time fridayClose;
    private Time saturdayOpen;
    private Time saturdayClose;
    private String image;
    private String imageWide;
    private String imageWide2;
    private String description;


    public Landmark() { }

    public Landmark(int i, String s, String monument, String s1, float v, float v1, int i1, int i2, String s2) {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Time getSundayOpen() {
        return sundayOpen;
    }
    public void setSundayOpen(Time sundayOpen) {
        this.sundayOpen = sundayOpen;
    }
    public Time getSundayClose() {
        return sundayClose;
    }
    public void setSundayClose(Time sundayClose) {
        this.sundayClose = sundayClose;
    }
    public Time getMondayOpen() {
        return mondayOpen;
    }
    public void setMondayOpen(Time mondayOpen) {
        this.mondayOpen = mondayOpen;
    }
    public Time getMondayClose() {
        return mondayClose;
    }
    public void setMondayClose(Time mondayClose) {
        this.mondayClose = mondayClose;
    }
    public Time getTuesdayOpen() {
        return tuesdayOpen;
    }
    public void setTuesdayOpen(Time tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }
    public Time getTuesdayClose() {
        return tuesdayClose;
    }
    public void setTuesdayClose(Time tuesdayClose) {
        this.tuesdayClose = tuesdayClose;
    }
    public Time getWednesdayOpen() {
        return wednesdayOpen;
    }
    public void setWednesdayOpen(Time wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }
    public Time getWednesdayClose() {
        return wednesdayClose;
    }
    public void setWednesdayClose(Time wednesdayClose) {
        this.wednesdayClose = wednesdayClose;
    }
    public Time getThursdayOpen() {
        return thursdayOpen;
    }
    public void setThursdayOpen(Time thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }
    public Time getThursdayClose() {
        return thursdayClose;
    }
    public void setThursdayClose(Time thursdayClose) {
        this.thursdayClose = thursdayClose;
    }
    public Time getFridayOpen() {
        return fridayOpen;
    }
    public void setFridayOpen(Time fridayOpen) {
        this.fridayOpen = fridayOpen;
    }
    public Time getFridayClose() {
        return fridayClose;
    }
    public void setFridayClose(Time fridayClose) {
        this.fridayClose = fridayClose;
    }
    public Time getSaturdayOpen() {
        return saturdayOpen;
    }
    public void setSaturdayOpen(Time saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }
    public Time getSaturdayClose() {
        return saturdayClose;
    }
    public void setSaturdayClose(Time saturdayClose) {
        this.saturdayClose = saturdayClose;
    }
    public String getImage() {
        return image;
    }
    public String getImageWide() {
        return imageWide;
    }
    public void setImageWide(String imageWide) {
        this.imageWide = imageWide;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImageWide2() { return imageWide2; }
    public void setImageWide2(String imageWide2) { this.imageWide2 = imageWide2; }
    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }


    public Landmark( long id, String name, String category, String address,float latitude, float longitude, Time sundayOpen,
                Time sundayClose, Time mondayOpen, Time mondayClose, Time tuesdayOpen, Time tuesdayClose, Time wednesdayOpen, Time wednesdayClose, Time thursdayOpen,
                Time thursdayClose, Time fridayOpen, Time fridayClose, Time saturdayOpen, Time saturdayClose, String image, String description){
            this.id = id;
            this.name = name;
            this.category = category;
            this.address = address;
            this.latitude = latitude;
            this.longitude = longitude;
            this.sundayOpen = sundayOpen;
            this.sundayClose = sundayClose;
            this.mondayOpen = mondayOpen;
            this.mondayClose = mondayClose;
            this.tuesdayOpen = tuesdayOpen;
            this.tuesdayClose = tuesdayClose;
            this.wednesdayOpen = wednesdayOpen;
            this.wednesdayClose = wednesdayClose;
            this.thursdayOpen = thursdayOpen;
            this.thursdayClose = thursdayClose;
            this.fridayOpen = fridayOpen;
            this.fridayClose = fridayClose;
            this.saturdayOpen = saturdayOpen;
            this.saturdayClose = saturdayClose;
            this.image = image;
            this.description = description;
        }

    }

