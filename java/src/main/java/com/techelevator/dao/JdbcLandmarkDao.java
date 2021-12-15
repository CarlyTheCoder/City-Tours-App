package com.techelevator.dao;

import com.techelevator.model.Landmark;
import com.techelevator.model.LandmarkDTO;
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
     public Landmark getById(long id) {
         Landmark landmark = new Landmark();
         String sql = "SELECT * FROM landmarks WHERE id = ?;";
         SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
         if (result.next()) {
             landmark = mapRowToLandmark(result);
         }
         return landmark;
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


    @Override
    public List<LandmarkDTO> getByItineraryId(long itineraryId) {
        List<LandmarkDTO> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM landmarks " +
                "JOIN itineraries_landmarks on landmarks.id = itineraries_landmarks.landmark_id " +
                "WHERE itineraries_landmarks.itinerary_id = ? ORDER BY order_position;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
        while (results.next()) {
            LandmarkDTO landmark = mapRowToLandmarkDTO(results);
            filteredList.add(landmark);
        }
        return filteredList;
    }

    @Override
    public void deleteLandmarkByItineraryId(long id) {
        String sql = "  DELETE FROM itineraries_landmarks WHERE itinerary_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int getLikes(long landmarkId) {
        String sql = "SELECT COUNT(*) FROM landmark_likes WHERE landmark_id = ?;";
        int likeCount = 0;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId);
        if (result.next()) {
            likeCount = result.getInt("count");
        }
        return likeCount;
    }

    @Override
    public int getDislikes(long landmarkId) {
        String sql = "SELECT COUNT(*) FROM landmark_dislikes WHERE landmark_id = ?;";
        int dislikeCount = 0;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId);
        if (result.next()) {
            dislikeCount = result.getInt("count");
        }
        return dislikeCount;
    }

    @Override
    public boolean getIsLiked(long landmarkId, long userId) {
         String sql = "SELECT COUNT(*) FROM landmark_likes WHERE landmark_id = ? " +
                 "AND user_id = ?;";
         boolean isLiked = false;
         SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId, userId);
         if (result.next()) {
             if (result.getInt("count") > 0) {
                isLiked = true;
             }
         }
        return isLiked;
    }

    @Override
    public boolean getIsDisliked(long landmarkId, long userId) {
        String sql = "SELECT COUNT(*) FROM landmark_dislikes WHERE landmark_id = ? " +
                "AND user_id = ?;";
        boolean isDisliked = false;
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId, userId);
        if (result.next()) {
            if (result.getInt("count") > 0) {
                isDisliked = true;
            }
        }
        return isDisliked;
    }


    @Override
    public void addLike(long landmarkId, long userId) {
        String sql = "INSERT INTO landmark_likes (landmark_id, user_id) VALUES (?,?);";
        jdbcTemplate.update(sql, landmarkId, userId);
    }


    @Override
    public void addDislike(long landmarkId, long userId) {
        String sql = "INSERT INTO landmark_dislikes (landmark_id, user_id) VALUES (?,?);";
        jdbcTemplate.update(sql, landmarkId, userId);
    }

    @Override
    public void removeLike(long landmarkId, long userId) {
        String sql ="DELETE FROM landmark_likes WHERE landmark_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, landmarkId, userId);
    }

    @Override
    public void removeDislike(long landmarkId, long userId) {
        String sql ="DELETE FROM landmark_dislikes WHERE landmark_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, landmarkId, userId);
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
        landmark.setImageWide(result.getString("image_wide"));
        landmark.setImageWide2(result.getString("image_wide_2"));
        landmark.setDescription(result.getString("description"));
        return landmark;
    }

    private LandmarkDTO mapRowToLandmarkDTO(SqlRowSet result) {

        LandmarkDTO landmark = new LandmarkDTO();
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
        landmark.setImageWide(result.getString("image_wide"));
        landmark.setImageWide2(result.getString("image_wide_2"));
        landmark.setDescription(result.getString("description"));
        landmark.setOrder(result.getInt("order_position"));
        return landmark;
    }
}
