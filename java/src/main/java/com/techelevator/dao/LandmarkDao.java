package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;


public interface LandmarkDao {

    List<Landmark> getAll();

    List<Landmark> filter(String name, String category, String day);
}
