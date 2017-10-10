package com.kodilla.good.patterns.challenges.fourthchanllenge.processing;

import com.kodilla.good.patterns.challenges.fourthchanllenge.repository.DummyDB;
import com.kodilla.good.patterns.challenges.fourthchanllenge.repository.FlightRoute;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightBrowser {
    public Map<Integer, FlightRoute> findAllFrom(DummyDB db, String from) {
        return db
                .getDb()
                .entrySet()
                .stream()
                .filter(integerFlightRouteEntry -> integerFlightRouteEntry
                        .getValue()
                        .getRoute()
                        .get(0)
                        .equals(from))
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue));
    }

    public Map<Integer, FlightRoute> findAllTo(DummyDB db, String to) {// może zwyczajnie nie da się tego zrobić jednym streamem??

        Map lengths = db
                .getDb()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(HashMap.Entry::getKey,
                        e->e
                                .getValue()
                                .getRoute()
                                .size()));



        for //filtrowanie w forze i sprawdzanei pozycji z size -1

    }

    public Map<Integer, FlightRoute> findAllVia(DummyDB db, String via) {
        return db
                .getDb()
                .entrySet()
                .stream()
                .filter(integerFlightRouteEntry -> integerFlightRouteEntry
                        .getValue()
                        .getRoute()
                        .contains(via))
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue));
    }
}
