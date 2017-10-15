package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calc;

    @Test
    public void Should_CalculateSum() {
        //Given
        double a = 2.0;
        double b = 3.0;
        //When
        Double actualSumResult = calc.add(a, b);
        //Then
        Assert.assertEquals(5.0, actualSumResult, 0.001);
    }


    @Test
    public void Should_CalculateSub() {
        //Given
        double a = 2.0;
        double b = 3.0;
        //When
        Double actualSubResult = calc.sub(a, b);
        //Then
        Assert.assertEquals(-1.0, actualSubResult, 0.001);
    }


    @Test
    public void Should_CalculateMul() {
        //Given
        double a = 2.0;
        double b = 3.0;
        //When
        Double actualMulResult = calc.mul(a, b);
        //Then
        Assert.assertEquals(6.0, actualMulResult, 0.001);
    }


    @Test
    public void Should_CalculateDiv() {
        //Given
        double a = 2.0;
        double b = 3.0;
        //When
        Double actualDivResult = calc.div(a, b);
        //Then
        Assert.assertEquals(0.6666, actualDivResult, 0.001);
    }

    @Test
    public void Should_HandleDivisionByZero() {
        //Given
        double a = 2.0;
        double b = 0.0;
        //When
        Double actualDivResult = calc.div(a, b);
        //Then
        Assert.assertEquals(Double.POSITIVE_INFINITY, actualDivResult, 0.001);
    }
}
