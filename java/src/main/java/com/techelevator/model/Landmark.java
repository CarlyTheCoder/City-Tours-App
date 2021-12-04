package com.techelevator.model;

public class Landmark {
    private Integer id;
    private String name;
    private String category;
    private String address;
    private String coordinates;
    private Integer openFrom;
    private Integer openTo;
    private Integer longitude;
    private Integer latitude;

    public Landmark(Integer id, String name, String category, String address, String coordinates,
                    Integer openFrom, Integer openTo, Integer longitude, Integer latitude) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.address = address;
        this.coordinates = coordinates;
        this.openFrom = openFrom;
        this.openTo = openTo;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Landmark(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
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

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }
}

