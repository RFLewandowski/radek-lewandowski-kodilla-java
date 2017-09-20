package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException() {
        System.out.println("Pull up! No airport found! <LOL>");
    }
}
