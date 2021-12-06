package com.techelevator.model;

public class Landmark {
    private long id;
    private String name;
    private String category;
    private String address;
    private float latitude;
    private float longitude;
    private Integer openFrom;
    private Integer openTo;



    public Landmark(long id, String name, String category, String address,
                    float latitude, float longitude, Integer openFrom, Integer openTo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openFrom = openFrom;
        this.openTo = openTo;
    }
    public Landmark(){

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
    public Integer getOpenFrom() {
        return openFrom;
    }
    public void setOpenFrom(Integer openFrom) {
        this.openFrom = openFrom;
    }
    public Integer getOpenTo() {
        return openTo;
    }
    public void setOpenTo(Integer openTo) {
        this.openTo = openTo;
    }




}

