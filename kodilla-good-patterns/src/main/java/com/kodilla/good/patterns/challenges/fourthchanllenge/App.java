package com.kodilla.good.patterns.challenges.fourthchanllenge;

import com.kodilla.good.patterns.challenges.fourthchanllenge.processing.FlightBrowser;
import com.kodilla.good.patterns.challenges.fourthchanllenge.repository.DummyDB;

import java.util.ArrayList;
import java.util.Arrays;

public class App {


    public static void main(String[] args) {

        FlightBrowser flightBrowser = new FlightBrowser();
        DummyDB dummyDB = new DummyDB();
        dummyDB.setUpDb();

        System.out.println(flightBrowser
                .findAllTo(dummyDB, "Krakow")
                .toString());
    }
}
