package com.kodilla.good.patterns.challenges.firstChallenge;

import java.util.*;
import java.util.stream.Collectors;

public class MovieStore {

    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        Collections.addAll(ironManTranslations, "Żelazny Człowiek", "Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        Collections.addAll(avengersTranslations, "Mściciele", "Avengers");

        List<String> flashTranslations = new ArrayList<>();
        Collections.addAll(flashTranslations, "Błyskawica", "Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public String getMovieTitles() {
        return getMovies()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining("!"));
    }
}
