package com.kodilla.exception.test;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class FlightDB {
    Map<String, Boolean> accessibleAirports = new HashMap<>();

    void init() {
        accessibleAirports.put("Hartsfield–Jackson", false);
        accessibleAirports.put("Beijing", false);
        accessibleAirports.put("Dubai", true);
        accessibleAirports.put("LA", true);
        accessibleAirports.put("Heathrow", false);
        accessibleAirports.put("Denver", true);
        accessibleAirports.put("Kuala Lumpur", true);
    }

    Boolean findFilght(Flight flight) throws RouteNotFoundException {
        String targetAirport = flight.getArrivalAirport();

        if (accessibleAirports.containsKey(targetAirport)) {
            return accessibleAirports.get(targetAirport);
        } else {
            throw new RouteNotFoundException("Pull UP!!");
        }
    }
}
