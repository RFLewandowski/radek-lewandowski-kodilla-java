package com.kodilla.exception.test;

public class FlightFinder {
    public static void main(String[] args) throws RouteNotFoundException {
        FlightDB flightDB = new FlightDB();
        flightDB.init();

        Flight[] flights= new Flight[6];
        flights[0] = new Flight("here", "Dubai");
        flights[1] = new Flight("here", "Hartsfield–Jackson");
        flights[2] = new Flight("here", "Beijing");
        flights[3] = new Flight("here", "Heathrow");
        flights[4] = new Flight("here", "Denver");
        flights[5] = new Flight("here", "Tokio");

        for (Flight flight : flights) {
            System.out.print("Is airport in " + flight.getArrivalAirport() + " acessible: ");
            System.out.println(flightDB.findFilght(flight));
        }
    }
}
