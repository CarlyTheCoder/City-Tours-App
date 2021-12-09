package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.model.Itinerary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/itineraries")
public class ItineraryController {

    private ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }


    @RequestMapping(path= "/users/{userId}", method = RequestMethod.GET)
    List<Itinerary> getItinerariesByUserId(@PathVariable int userId) {

            return itineraryDao.getItinerariesByUserId(userId);

    }

}
