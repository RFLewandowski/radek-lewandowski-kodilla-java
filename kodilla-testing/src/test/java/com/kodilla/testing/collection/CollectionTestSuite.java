package com.kodilla.testing.collection;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }


    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        String whoAmI = Thread.currentThread().getStackTrace()[1].getMethodName();
        OddNumbersExterminator one = new OddNumbersExterminator();
        ArrayList<Integer> testList = new ArrayList<>();

        //When
        System.out.println("Test: " + whoAmI);
        ArrayList<Integer> result = one.exterminate(testList);
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        /*TODO
        1. whoAmI możnaby wyjąć do metody prywatnej (oczywiscie wtedy trzebaby zmienic na inny numerek w getStackTrace())
        */
        String whoAmI = Thread.currentThread().getStackTrace()[1].getMethodName();
        OddNumbersExterminator one = new OddNumbersExterminator();
        ArrayList<Integer> testList = generateTestPairLists().left;
        ArrayList<Integer> expected1 = generateTestPairLists().right;
        //When
        System.out.println("Test: " + whoAmI);
        ArrayList<Integer> actual1 = one.exterminate(testList);
        //Then
        Assert.assertEquals(expected1, actual1);
    }


    private ImmutablePair<ArrayList<Integer>, ArrayList<Integer>> generateTestPairLists() {

        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(-1);
        testList.add(0);
        testList.add(99);
        testList.add(1239999999);
        testList.add(-1239999999);
        testList.add(222222222);
        testList.add(8888222);

        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(222222222);
        expected1.add(8888222);

        return ImmutablePair.of(testList, expected1);
    }
}
