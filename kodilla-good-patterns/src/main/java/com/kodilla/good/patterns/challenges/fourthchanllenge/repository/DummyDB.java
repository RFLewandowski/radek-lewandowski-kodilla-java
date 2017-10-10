package com.kodilla.good.patterns.challenges.fourthchanllenge.repository;

import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Value
public class DummyDB {
    private Map<Integer, FlightRoute> db = new HashMap<>();

    public void setUpDb() {
        FlightRoute fr = null;
        ArrayList[] routes = this.initRoutes();

        for (int i = 0; i <= 5; i++) {
            fr = new FlightRoute(routes[i]);
            db.put(i, fr);
        }
    }

    private ArrayList[] initRoutes() {
        ArrayList<String> f0 = new ArrayList<>(Arrays.asList("Gdansk", "Wroclaw", "Krakow"));
        ArrayList<String> f1 = new ArrayList<>(Arrays.asList("Katowice", "Warszawa", "Gdansk"));
        ArrayList<String> f2 = new ArrayList<>(Arrays.asList("Katowice", "Warszawa", "Zielona gora"));
        ArrayList<String> f3 = new ArrayList<>(Arrays.asList("Warszawa", "Moskwa", "Wladywostok"));
        ArrayList<String> f4 = new ArrayList<>(Arrays.asList("Warszawa", "Moskwa", "Tokio"));
        ArrayList<String> f5 = new ArrayList<>(Arrays.asList("Warszawa", "Berlin", "Frankfurt"));
        return new ArrayList[]{f0, f1, f2, f3, f4, f5};
    }
}