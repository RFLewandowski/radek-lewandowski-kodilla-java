package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BasicPizzaOrderTestSuite {
    @Test
    public void Should_GetCost_When_OrderedWithSauceAndCheese() throws Exception {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new PizzaWithCheese(pizza);
        pizza = new PizzaWithSauce(pizza);

        //When
        BigDecimal actulCost = pizza.getCost();
        //Then
        assertEquals(new BigDecimal(25), actulCost);

    }

    @Test
    public void Should_GetDescription_When_OrderedWithSauceAndCheese() throws Exception {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new PizzaWithCheese(pizza);
        pizza = new PizzaWithSauce(pizza);

        //When
        String actulDescription = pizza.getDescription();
        //Then
        assertEquals("Pizza + Cheese + Sauce", actulDescription);
    }

}