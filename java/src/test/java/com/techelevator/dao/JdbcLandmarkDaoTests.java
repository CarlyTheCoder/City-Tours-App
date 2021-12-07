package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcLandmarkDaoTests extends FinalCapstoneDaoTests {

    private static final Landmark LANDMARK_1=new Landmark(7,"\"The Fist\"","monument","5 Woodward Ave, Detroit, MI 48226",42.329437f,
            -83.04466f,0,24,"https://i.imgur.com/94yzCFw.jpg?1");

    private JdbcLandmarkDao sut;
    private Landmark landmarkTest;
    @Before
    public void setup() {

        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcLandmarkDao(jdbcTemplate);
    }
    @Test
    public void returnAllLandmarkList(){
    List<Landmark> landmarkList=sut.getAll();
    Assert.assertEquals(9,landmarkList.size());
    assertLandmarkMATCH(LANDMARK_1,landmarkList.get(0));

    }

    private void assertLandmarkMATCH(Landmark expected, Landmark actual) {
        Assert.assertEquals(expected.getId(),actual.getId());
        Assert.assertEquals(expected.getName(),actual.getName());
        Assert.assertEquals(expected.getCategory(),actual.getCategory());
        Assert.assertEquals(expected.getAddress(),actual.getAddress());
        Assert.assertEquals(expected.getLatitude(),actual.getLatitude(),0.00f);
        Assert.assertEquals(expected.getLongitude(),actual.getLongitude(),0.00f);
        Assert.assertEquals(expected.getImage(),actual.getImage());
    }



}
