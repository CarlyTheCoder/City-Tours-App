package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;


public interface LandmarkDao {

    List<Landmark> getAll();

    Landmark searchByName();

    Landmark searchByLatitude();

    Landmark searchByLongitude();

    Landmark searchByCategory();
}
