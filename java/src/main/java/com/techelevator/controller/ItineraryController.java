package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.model.Itinerary;
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

    @RequestMapping(path= "itineraries/{itineraryId}", method = RequestMethod.GET)
    Itinerary getById( @PathVariable long itineraryId) {
            return itineraryDao.getById(itineraryId);
    }

}
