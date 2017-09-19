package com.kodilla.exception.test;

public class FlightFinder {
    public static void main(String[] args) throws RouteNotFoundException {
        FlightDB flightDB = new FlightDB();
        flightDB.init();

        Flight f1 = new Flight("here", "Dubai");
        Flight f2 = new Flight("here", "Hartsfield–Jackson");
        Flight f3 = new Flight("here", "Beijing");
        Flight f4 = new Flight("here", "Heathrow");
        Flight f5 = new Flight("here", "Denver");
        Flight f6 = new Flight("here", "Tokio");

        System.out.println("Is airport: "+f1.getArrivalAirport()+" acessible: "+flightDB.findFilght(f1));
        System.out.println("Is airport: "+f2.getArrivalAirport()+" acessible: "+flightDB.findFilght(f2));
        System.out.println("Is airport: "+f3.getArrivalAirport()+" acessible: "+flightDB.findFilght(f3));
        System.out.println("Is airport: "+f4.getArrivalAirport()+" acessible: "+flightDB.findFilght(f4));
        System.out.println("Is airport: "+f5.getArrivalAirport()+" acessible: "+flightDB.findFilght(f5));
        System.out.println("Is airport: "+f6.getArrivalAirport()+" acessible: "+flightDB.findFilght(f6));
    }
}
