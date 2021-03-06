package com.kodilla.exception.test;

public class FlightFinder {
    public static void main(String[] args) {
        FlightDB flightDB = new FlightDB();
        flightDB.init();

        Flight[] flights = new Flight[6];
        flights[0] = new Flight("here", "Dubai");
        flights[1] = new Flight("here", "Hartsfield–Jackson");
        flights[2] = new Flight("here", "Beijing");
        flights[3] = new Flight("here", "Heathrow");
        flights[4] = new Flight("here", "Denver");
        flights[5] = new Flight("here", "Tokyo");

        for (Flight flight : flights) {
            System.out.print("Is airport in " + flight.getArrivalAirport() + " acessible: ");
            try {
                System.out.println(flightDB.findFilght(flight));
            } catch (RouteNotFoundException e) {
                System.out.println("there is no airport in " + flight.getArrivalAirport() + " anymore.");
                e.printStackTrace();
            }
        }
    }
}
