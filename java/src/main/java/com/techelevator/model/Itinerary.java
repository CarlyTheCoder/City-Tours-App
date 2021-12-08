package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Itinerary {

    private int id;
    private String name;
    private int startingPoint;
    private List<Landmark> landmarks;
    private Date visitDate;

    public Itinerary() {
    }

    public Itinerary(int id, String name, int startingPoint, List<Landmark> landmarks, Date visitDate) {
        this.id = id;
        this.name = name;
        this.startingPoint = startingPoint;
        this.landmarks = landmarks;
        this.visitDate = visitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Landmark> landmarks) {
        this.landmarks = landmarks;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
