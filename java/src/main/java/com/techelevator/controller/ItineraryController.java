package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.model.Itinerary;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ItineraryController {

    private ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    @RequestMapping(path = "/users/{userId}/itineraries", method = RequestMethod.GET)
    List<Itinerary> getAll(@PathVariable long userId) {
        return itineraryDao.getAll(userId);
    }

    @RequestMapping(path= "/itineraries/{itineraryId}", method = RequestMethod.GET)
    Itinerary getById( @PathVariable long itineraryId) {
            return itineraryDao.getById(itineraryId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/itineraries", method = RequestMethod.POST)
    Itinerary create(@RequestBody Itinerary itinerary) {
        return itineraryDao.create(itinerary);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/itineraries/{itineraryId}/landmarks/{landmarkId}", method = RequestMethod.POST)
    void addLandmark(@PathVariable long itineraryId, @PathVariable long landmarkId) {
        itineraryDao.addLandmark(itineraryId, landmarkId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/itineraries/{id}", method = RequestMethod.DELETE)
    void deleteItineraries(@PathVariable  long id){
        itineraryDao.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/itineraries/{itineraryId}/landmarks/{landmarkId}", method = RequestMethod.DELETE)
    void deleteLandmarkFromItinerary( @PathVariable long itineraryId, @PathVariable long landmarkId) {
        itineraryDao.deleteLandmarkFromItinerary(itineraryId, landmarkId);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/itineraries/{itineraryId}")
    void update(@RequestBody Itinerary itinerary,@PathVariable long itineraryId){
        itineraryDao.update(itinerary,itineraryId);
    }

}
