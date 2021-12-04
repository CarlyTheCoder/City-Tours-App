package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;


public interface LandmarkDao {
    List<Landmark> findAll();
    Landmark findByName();
    Landmark findByLongitude();
    Landmark getByLatitude();
    Landmark getByCategory();
}
