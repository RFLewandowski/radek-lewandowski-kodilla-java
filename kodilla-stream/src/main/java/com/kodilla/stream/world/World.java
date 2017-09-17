package com.kodilla.stream.world;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Set;

@Value
public class World {
    Set<Continent> continentsOfTheWorld;

    BigDecimal getPeopleQuantity() {
        return continentsOfTheWorld
                .stream()
                .flatMap(continent -> continent.getCountriesOfContinent().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
