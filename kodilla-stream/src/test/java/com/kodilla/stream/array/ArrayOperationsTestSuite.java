package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {


    @Test
    public void should_returnAverage() {
        //Given
        int[] testArray = {3, 3, 3, 3, 2, 2, 2, 2};
        OptionalDouble expectedResult = OptionalDouble.of(2.5);

        //When
        OptionalDouble calculatedAverage = ArrayOperations.getAverage(testArray);

        //Then
        Assert.assertEquals(OptionalDouble.of(2.5), calculatedAverage);
    }
}
