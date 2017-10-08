package com.kodilla.good.patterns.challenges.firstchallenge;

public class App {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movieTitles = movieStore.getMovieTitles();
        System.out.println(movieTitles);
    }
}