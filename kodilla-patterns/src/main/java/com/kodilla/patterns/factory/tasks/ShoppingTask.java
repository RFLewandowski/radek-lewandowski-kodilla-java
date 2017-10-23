package com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class ShoppingTask extends AbstractTask{
    private final String whatToBuy;
    private final double quantity;

    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        super(taskName);
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.TaskExecuted = false;
    }

}
