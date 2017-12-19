package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MyTaxiNetworkOrderDecoratorTest {
    @Test
    public void Should_GetCostWhen_When_ChildSeatAdded() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal actualCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), actualCost);
    }

    @Test
    public void Should_GetDescription_When_ChildSeatAdded() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String actualDescription = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", actualDescription);
    }

}