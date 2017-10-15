package com.kodilla.good.patterns.challenges.fourthchanllenge.repository;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Value
public class DummyDB {
    private Map<Integer, FlightRoute> db = new HashMap<>();

    public void fillInDatabase(ArrayList[] routes) {
        FlightRoute fr = null;

        for (int i = 0; i < routes.length; i++) {
            fr = new FlightRoute(routes[i]);
            db.put(i, fr);
        }
    }
}