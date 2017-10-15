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

    public Map<Integer, FlightRoute> findAllTo(DummyDB db, String to) {

        return db
                .getDb()
                .entrySet()
                .stream()
                .filter(integerFlightRouteEntry -> integerFlightRouteEntry
                        .getValue()
                        .getRoute()
                        .toString()
                        .endsWith(to + "]"))
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue));
    }

    public Map<Integer, FlightRoute> findAllVia(DummyDB db, String via) {
        return db
                .getDb()
                .entrySet()
                .stream()
                .filter(integerFlightRouteEntry -> integerFlightRouteEntry
                        .getValue()
                        .getRoute()
                        .toString()
                        .contains(" " + via + ","))
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue));
    }
}
