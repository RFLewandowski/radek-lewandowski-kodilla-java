package com.kodilla.good.patterns.challenges.fourthchanllenge.repository;

import lombok.Value;

import java.util.*;

@Value
public class DummyDB {
    Map<Integer, FlightRoute> db = new HashMap<>();

    static {
        ArrayList<String> f1= new ArrayList<>(); //tutaj zawartość flightRoute





        List<FlightRoute> flightRoutes = new ArrayList(); //tutaj tworzenei obiektów flight route
        for (int i = 0; i < 5; i++) {
            flightRoutes.add(new FlightRoute());
        }
        
        
        
//        Collections.addAll(flightRoutes,) //tutaj wypełnainie obiektów flight route zawartoscią


// brakuje jeszcze wypełniania bazy danych fliht routami

    }
}