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
    public List<Landmark> findAll() {
         List<Landmark> landmarks=new ArrayList<>();
      String sql="SELECT name,category,address,coordinates,open_from,open_to FROM landmarks;";
        SqlRowSet result=jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Landmark landmark=mapRowToLandmark(result);
            landmarks.add(landmark);
        }
        return landmarks;
    }

    @Override
    public Landmark findByName() {
        return null;
    }

    @Override
    public Landmark findByLongitude() {
        return null;
    }

    @Override
    public Landmark getByLatitude() {
        return null;
    }

    @Override
    public Landmark getByCategory() {
        return null;
    }
    private  Landmark mapRowToLandmark(SqlRowSet result){
         Landmark landmark=new Landmark();
         landmark.setName(result.getString("name"));
        landmark.setCategory(result.getString("category"));
        landmark.setAddress(result.getString("address"));
        landmark.setCoordinates(result.getString("coordinates"));
        landmark.setOpenFrom(result.getInt("open_from"));
        landmark.setOpenTo(result.getInt("open_to"));
        landmark.setLongitude(result.getInt("longitude"));
        landmark.setLatitude(result.getInt("latitude"));

        return landmark;
    }

}
