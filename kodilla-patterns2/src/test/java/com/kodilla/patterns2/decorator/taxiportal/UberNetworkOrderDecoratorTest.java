package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class UberNetworkOrderDecoratorTest {
    @Test
    public void Should_GetCostWhen_When_TwoChildSeatsAdded() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new UberNetworkOrderDecorator(theOrder);

        //When
        BigDecimal actualCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(29), actualCost);

    }

    @Test
    public void Should_GetDescription_When_TwoChildSeatsAdded() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String actualDescription = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", actualDescription);

    }

}