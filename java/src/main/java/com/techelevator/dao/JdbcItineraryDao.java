package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;};

    @Override
    public List<Itinerary> getItinerariesByUserId(int userId) {
        List<Itinerary> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM itineraries WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itinerary.setLandmarks(getLandmarksByItineraryId(itinerary.getId()));
            filteredList.add(itinerary);
        }
        return filteredList;
    }

    @Override
    public List<Landmark> getLandmarksByItineraryId(int itineraryId) {
        List<Landmark> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM landmarks " +
                "LEFT JOIN itineraries_landmarks on landmarks.id = itineraries_landmarks.landmark_id " +
                "WHERE itinerary_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
        while (results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            filteredList.add(landmark);
        }
        return filteredList;
    }

    private  Itinerary mapRowToItinerary(SqlRowSet result) {

        Itinerary itinerary = new Itinerary();
        itinerary.setId(result.getInt("id"));
        itinerary.setName(result.getString("name"));
        itinerary.setStartingPoint(result.getInt("starting_point"));

        itinerary.setVisitDate(result.getDate("trip_date"));

        return itinerary;
    }

    private  Landmark mapRowToLandmark(SqlRowSet result) {

        Landmark landmark = new Landmark();
        landmark.setId(result.getLong("id"));
        landmark.setName(result.getString("name"));
        landmark.setCategory(result.getString("category"));
        landmark.setAddress(result.getString("address"));
        landmark.setLatitude(result.getFloat("latitude"));
        landmark.setLongitude(result.getFloat("longitude"));
        landmark.setSundayOpen(result.getTime("sunday_open"));
        landmark.setSundayClose(result.getTime("sunday_close"));
        landmark.setMondayOpen(result.getTime("monday_open"));
        landmark.setMondayClose(result.getTime("monday_close"));
        landmark.setTuesdayOpen(result.getTime("tuesday_open"));
        landmark.setTuesdayClose(result.getTime("tuesday_close"));
        landmark.setWednesdayOpen(result.getTime("wednesday_open"));
        landmark.setWednesdayClose(result.getTime("wednesday_close"));
        landmark.setThursdayOpen(result.getTime("thursday_open"));
        landmark.setThursdayClose(result.getTime("thursday_close"));
        landmark.setFridayOpen(result.getTime("friday_open"));
        landmark.setFridayClose(result.getTime("friday_close"));
        landmark.setSaturdayOpen(result.getTime("saturday_open"));
        landmark.setSaturdayClose(result.getTime("saturday_close"));
        landmark.setImage(result.getString("image"));
        landmark.setDescription(result.getString("description"));
        return landmark;
    }



}
