package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getAll(long userId);
    Itinerary getById(long itineraryId);
    Itinerary create(Itinerary itinerary);
}
