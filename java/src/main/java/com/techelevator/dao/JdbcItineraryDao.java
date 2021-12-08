package com.techelevator.dao;

import com.techelevator.model.Itinerary;
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
    public List<Itinerary> filter() {
        List<Itinerary> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM itineraries";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            filteredList.add(itinerary);
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



}
