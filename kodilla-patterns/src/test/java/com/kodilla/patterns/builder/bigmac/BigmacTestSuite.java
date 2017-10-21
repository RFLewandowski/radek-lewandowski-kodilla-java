package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void Should_buildBigmac() {
        //Given
        Pizza pizza = new Pizza
                .PizzaBuilder()
                .bottom("whatever")
                .sauce("onion sauce")
                .ingredient("onion")
                .ingredient("onion")
                .ingredient("chocolate")
                .build();

        //When
        String bottom = pizza.getBottom();
        boolean containsChocolate = pizza
                .getIngredients()
                .contains("chocolate");

        //Then
        Assert.assertEquals("whatever", bottom);
        Assert.assertEquals(containsChocolate, true);
    }
}
