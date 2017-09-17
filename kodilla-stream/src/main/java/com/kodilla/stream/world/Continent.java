package com.kodilla.stream.world;

import lombok.Value;

import java.util.Set;

@Value
public class Continent {
    Set<Country> countriesOfContinent;
}
