package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {


    @Test
    public void should_returnAverage() {
        //Given
        int[] testArray = {3, 3, 3, 3, 2, 2, 2, 2};

        //When
        Double calculatedAverage = ArrayOperations.getAverage(testArray);

        //Then
        Assert.assertEquals(2.5, calculatedAverage, 0.01);

    }
}
