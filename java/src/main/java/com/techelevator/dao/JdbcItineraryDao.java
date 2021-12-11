package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;
    private LandmarkDao landmarkDao;
    public JdbcItineraryDao(JdbcTemplate jdbcTemplate, LandmarkDao landmarkDao) {
    this.jdbcTemplate = jdbcTemplate; this.landmarkDao = landmarkDao;};

    @Override
    public List<Itinerary> getAll(long userId) {
        List<Itinerary> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM itineraries WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itinerary.setLandmarks(landmarkDao.getByItineraryId(itinerary.getId()));
            filteredList.add(itinerary);
        }
        return filteredList;
    }

    @Override
    public Itinerary getById(long itineraryId) {
        Itinerary itinerary = new Itinerary();
        String sql = "SELECT * FROM itineraries WHERE itineraries.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
        if (results.next()) {
            itinerary = mapRowToItinerary(results);
            itinerary.setLandmarks(landmarkDao.getByItineraryId(itinerary.getId()));
        }
        return itinerary;
    }

    @Override
    public Itinerary create(Itinerary itinerary) {
    Itinerary newItinerary = new Itinerary();
    String sql = "INSERT INTO itineraries (user_id, name, starting_point, trip_date) VALUES (?, ?, ?, ?) RETURNING id;";
    long newId = jdbcTemplate.queryForObject(sql, long.class, itinerary.getUserId(), itinerary.getName(), itinerary.getStartingPoint(),
            itinerary.getTripDate());
    return getById(newId);
    }

    @Override
    public void addLandmark(long itineraryID, long landmarkId) {
        String sql = "INSERT INTO itineraries_landmarks (itinerary_id, landmark_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, itineraryID, landmarkId);
    }

    @Override
    public void delete(long id) {
        landmarkDao.deleteLandmarkByItineraryId(id);
        String sql=" DELETE FROM itineraries WHERE id=?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void deleteLandmarkFromItinerary(long itineraryId, long landmarkId) {
        String sql = "DELETE FROM itineraries_landmarks WHERE itinerary_id = ? AND landmark_id = ?;";
        jdbcTemplate.update(sql, itineraryId, landmarkId);
    }

    private  Itinerary mapRowToItinerary(SqlRowSet result) {

        Itinerary itinerary = new Itinerary();
        itinerary.setId(result.getLong("id"));
        itinerary.setUserId(result.getLong("user_id"));
        itinerary.setName(result.getString("name"));
        itinerary.setStartingPoint(result.getLong("starting_point"));
        itinerary.setTripDate(result.getDate("trip_date"));

        return itinerary;
    }



}
