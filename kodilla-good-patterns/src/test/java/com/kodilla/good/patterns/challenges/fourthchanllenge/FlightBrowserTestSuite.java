package com.kodilla.good.patterns.challenges.fourthchanllenge;

import com.kodilla.good.patterns.challenges.fourthchanllenge.processing.FlightBrowser;
import com.kodilla.good.patterns.challenges.fourthchanllenge.repository.DummyDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightBrowserTestSuite {
    private FlightBrowser flightBrowser;
    private DummyDB dummyDB;

    @Test
    public void Should_FindFlightsFrom() {
        //Given
        String expectedResult = "{3=FlightRoute(route=[Warszawa, Moskwa, Wladywostok]), 4=FlightRoute(route=[Warszawa," +
                " Moskwa, Krakow, Sopot]), 5=FlightRoute(route=[Warszawa, Berlin, Frankfurt, Amsterdam, Paryz])}";

        //When
        String actualResult = flightBrowser
                .findAllFrom(dummyDB, "Warszawa")
                .toString();

        //Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Should_FindFlightsTo() {
        //Given
        String expectedResult = "{5=FlightRoute(route=[Warszawa, Berlin, Frankfurt, Amsterdam, Paryz])}";

        //When
        String actualResult = flightBrowser
                .findAllTo(dummyDB, "Paryz")
                .toString();

        //Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Should_FindFlightsVia() {
        //Given
        String expectedResult = "{3=FlightRoute(route=[Warszawa, Moskwa, Wladywostok]), " +
                "4=FlightRoute(route=[Warszawa, Moskwa, Krakow, Sopot])}";

        //When
        String actualResult = flightBrowser
                .findAllVia(dummyDB, "Moskwa")
                .toString();

        //Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Before
    public void init() {
        flightBrowser = new FlightBrowser();
        dummyDB = new DummyDB();
        dummyDB.fillInDatabase(testRoutes());
    }

    private ArrayList[] testRoutes() {
        ArrayList<String> f0 = new ArrayList<>(Arrays.asList("Gdansk", "Wroclaw", "Krakow", "Lomza"));
        ArrayList<String> f1 = new ArrayList<>(Arrays.asList("Katowice", "Warszawa", "Gdansk"));
        ArrayList<String> f2 = new ArrayList<>(Arrays.asList("Katowice", "Tokio", "Zielona gora"));
        ArrayList<String> f3 = new ArrayList<>(Arrays.asList("Warszawa", "Moskwa", "Wladywostok"));
        ArrayList<String> f4 = new ArrayList<>(Arrays.asList("Warszawa", "Moskwa", "Krakow", "Sopot"));
        ArrayList<String> f5 = new ArrayList<>(Arrays.asList("Warszawa", "Berlin", "Frankfurt", "Amsterdam", "Paryz"));
        return new ArrayList[]{f0, f1, f2, f3, f4, f5};
    }
}
