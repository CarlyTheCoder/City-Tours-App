package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Itinerary {

    private long id;
    private String name;
    private long startingPoint;
    private List<Landmark> landmarks;
    private Date tripDate;

    public Itinerary() {

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

    public long getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(long startingPoint) {
        this.startingPoint = startingPoint;
    }

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Landmark> landmarks) {
        this.landmarks = landmarks;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }
}
