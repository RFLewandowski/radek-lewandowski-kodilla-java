package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class WorldTestSuite {


    @Test
    public void should_calculateAllPeople() {
        //Given
        //values of population has to differ because hashSet has nothing else to compare in equals; no matter as it is training assignment
        Country poland = new Country(new BigDecimal("1000000001"));
        Country france = new Country(new BigDecimal("1000000002"));
        Country holland = new Country(new BigDecimal("1000000003"));
        Country sweden = new Country(new BigDecimal("1000000004"));

        Set<Country> countriesOfEurope = new HashSet<>();
        countriesOfEurope.add(poland);
        countriesOfEurope.add(france);
        countriesOfEurope.add(holland);
        countriesOfEurope.add(sweden);

        Continent Europe = new Continent(countriesOfEurope);


        Country ivoryCoast = new Country(new BigDecimal("1000000005"));
        Country kongo = new Country(new BigDecimal("1000000006"));
        Country rpa = new Country(new BigDecimal("1000000007"));
        Country sudan = new Country(new BigDecimal("1000000008"));

        Set<Country> countriesOfAfrica = new HashSet<>();
        countriesOfAfrica.add(ivoryCoast);
        countriesOfAfrica.add(kongo);
        countriesOfAfrica.add(rpa);
        countriesOfAfrica.add(sudan);

        Continent Africa = new Continent(countriesOfAfrica);

        Set<Continent> continentsOfTheWorld = new HashSet<>();
        continentsOfTheWorld.add(Europe);
        continentsOfTheWorld.add(Africa);

        World world = new World(continentsOfTheWorld);

        //When

        BigDecimal allThePeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleNumber = new BigDecimal("8000000036");
        Assert.assertEquals(expectedPeopleNumber, allThePeople);
    }
}
