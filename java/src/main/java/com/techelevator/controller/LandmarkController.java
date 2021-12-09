package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/landmarks")
public class LandmarkController {

    private LandmarkDao landmarkDao;


    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    Landmark getById(@PathVariable long id) {
        return landmarkDao.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Landmark> getAll() {
       return landmarkDao.getAll();
    }

    @RequestMapping(path= "/filter", method = RequestMethod.GET)
    List<Landmark> filter(@RequestParam String name, @RequestParam String category, @RequestParam String day) {
        if (name.equals("") && category.equals("") && day.equals("")){
            return landmarkDao.getAll();
        } else {
            return landmarkDao.filter(name, category, day);
        }
    }


}
