package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcLandmarkDao implements LandmarkDao {
      private JdbcTemplate jdbcTemplate;

     public JdbcLandmarkDao(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate=jdbcTemplate;
     }

    @Override
    public List<Landmark> getAll() {
         List<Landmark> landmarks = new ArrayList<>();
      String sql = "SELECT id, name, category, address, latitude, longitude, open_from, open_to, image FROM landmarks " +
              "ORDER BY name";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()) {
            Landmark landmark = mapRowToLandmark(result);
            landmarks.add(landmark);
        }
        return landmarks;
    }

    @Override
    public Landmark searchByName() {
        return null;
    }

    @Override
    public Landmark searchByLatitude() {
        return null;
    }

    @Override
    public Landmark searchByLongitude() {
        return null;
    }

    @Override
    public Landmark searchByCategory() {
        return null;
    }

    private  Landmark mapRowToLandmark(SqlRowSet result) {

        Landmark landmark = new Landmark();
        landmark.setId(result.getLong("id"));
        landmark.setName(result.getString("name"));
        landmark.setCategory(result.getString("category"));
        landmark.setAddress(result.getString("address"));
        landmark.setLatitude(result.getFloat("latitude"));
        landmark.setLongitude(result.getFloat("longitude"));
        landmark.setOpenFrom(result.getInt("open_from"));
        landmark.setOpenTo(result.getInt("open_to"));
        landmark.setImage(result.getString("image"));
        return landmark;
    }

}
