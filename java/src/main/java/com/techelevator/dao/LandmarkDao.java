package com.techelevator.dao;

import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDTO;

import java.util.List;


public interface LandmarkDao {

    Landmark getById(long id);

    List<Landmark> getAll();

    List<Landmark> filter(String name, String category, String day);
    List<LandmarkDTO> getByItineraryId(long itineraryId);
    void deleteLandmarkByItineraryId(long id);
    int getLikes(long landmarkId);
    int getDislikes(long landmarkId);
    boolean getIsLiked(long landmarkId, long userId);
    boolean getIsDisliked(long landmarkId, long userId);
    void addLike(long landmarkId, long userId);
    void addDislike(long landmarkId, long userId);
    void removeLike(long landmarkId, long userId);
    void removeDislike(long landmarkId, long userId);

}
