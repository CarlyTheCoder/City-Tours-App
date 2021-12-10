package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;


public interface LandmarkDao {

    Landmark getById(long id);

    List<Landmark> getAll();

    List<Landmark> filter(String name, String category, String day);
    List<Landmark> getByItineraryId(long itineraryId);
    void deleteLandmarkByItineraryId(long id);
}
