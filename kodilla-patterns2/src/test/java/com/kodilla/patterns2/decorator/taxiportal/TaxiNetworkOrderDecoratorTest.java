package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiNetworkOrderDecoratorTest {
    @Test
    public void ShouldGetCost() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        BigDecimal actualCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(40), actualCost);
    }

    @Test
    public void ShouldGetDescription() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //When
        String actualDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", actualDescription);
    }

    @Test
    public void Should_GetCost_When_VIPChildSeatExpress() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        //When
        BigDecimal actualCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(57), actualCost);
    }

    @Test
    public void Should_GetDescription_When_VIPChildSeatExpress() throws Exception {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        //When
        String actualDescription = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network + variant VIP + child seat + express service", actualDescription);
    }


}