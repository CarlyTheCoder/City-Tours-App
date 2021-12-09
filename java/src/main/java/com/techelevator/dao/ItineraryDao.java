package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItinerariesByUserId(int userId);
    List<Landmark> getLandmarksByItineraryId(int itineraryId);
}
