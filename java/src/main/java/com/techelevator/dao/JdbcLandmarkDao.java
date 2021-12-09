package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class JdbcLandmarkDao implements LandmarkDao {
      private JdbcTemplate jdbcTemplate;

     public JdbcLandmarkDao(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate=jdbcTemplate;
     }

    @Override
    public List<Landmark> getAll() {
         List<Landmark> landmarks = new ArrayList<>();

      String sql = "SELECT * FROM landmarks " + "ORDER BY name";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarks.add(landmark);
        }
        return landmarks;
    }

    @Override
    public List<Landmark> filter(String name, String category, String day) {
         List<Landmark> filteredList = new ArrayList<>();
         String weekday = day.toLowerCase();
         String sql = "SELECT * FROM landmarks WHERE name ILIKE concat('%', ?, '%') " +
                "AND category ILIKE concat('%', ?, '%') " +
                "ORDER BY name";
         if (!weekday.equals("")) {
             sql = "SELECT * FROM landmarks WHERE name ILIKE concat('%', ?, '%') " +
                     "AND category ILIKE concat('%', ?, '%') " +
                     "AND " + weekday + "_close > " + weekday + "_open " +
                     "ORDER BY name";
         }
         SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name, category);
         while (results.next()) {
             Landmark landmark = mapRowToLandmark(results);
             filteredList.add(landmark);
         }
         return filteredList;
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
