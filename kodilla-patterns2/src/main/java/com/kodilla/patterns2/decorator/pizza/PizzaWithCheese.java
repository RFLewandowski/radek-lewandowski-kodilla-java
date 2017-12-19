package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaWithCheese extends AbstractPizzaDecorator {

    public PizzaWithCheese(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost()
                .add(new BigDecimal(5.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription().concat(" + Cheese");
    }
}
