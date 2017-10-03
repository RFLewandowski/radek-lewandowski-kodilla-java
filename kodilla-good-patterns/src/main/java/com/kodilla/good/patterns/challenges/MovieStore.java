package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class MovieStore {

    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

//    public String getMovieTitles() {
//
//                String result = getMovies()
//                .entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .collect(Collectors.joining("!"));
//        return result;
//    }


//    public String getMovieTitles() {
//
//        String result = getMovies()
//                .forEach((s, strings) -> {
//                    strings
//                            .stream()
//                            .collect(Collectors.joining("!"));
//                });
//        return result;
//    }


    public String getMovieTitles() {

        getMovies().forEach((s, strings) -> {
            strings
                    .stream()
                    .map(s1 -> s1 + "!")
                    .forEach(System.out::print);
        });

        return "";
    }
}