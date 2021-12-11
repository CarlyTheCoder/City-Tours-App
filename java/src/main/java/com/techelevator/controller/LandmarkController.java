package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(path = "/{landmarkId}/likes", method = RequestMethod.GET)
    int getLikes(@PathVariable long landmarkId) {
       return landmarkDao.getLikes(landmarkId);
    }


    @RequestMapping(path = "/{landmarkId}/dislikes", method = RequestMethod.GET)
    int getDislikes(@PathVariable long landmarkId) {
        return landmarkDao.getDislikes(landmarkId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{landmarkId}/dislikes/{userId}", method = RequestMethod.POST)
    void addDislike(@PathVariable long landmarkId, @PathVariable long userId) {
        landmarkDao.addDislike(landmarkId, userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{landmarkId}/likes/{userId}", method = RequestMethod.POST)
    void addLike(@PathVariable long landmarkId, @PathVariable long userId) {
        landmarkDao.addLike(landmarkId, userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/{landmarkId}/likes/{userId}")
    void removeLike(@PathVariable long landmarkId, @PathVariable long userId) {
        landmarkDao.removeLike(landmarkId, userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/{landmarkId}/dislikes/{userId}")
    void removeDislike(@PathVariable long landmarkId, @PathVariable long userId) {
        landmarkDao.removeDislike(landmarkId, userId);
    }

}
