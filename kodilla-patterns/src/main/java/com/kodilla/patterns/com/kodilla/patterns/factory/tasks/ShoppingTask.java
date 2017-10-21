package com.kodilla.patterns.com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class ShoppingTask implements Task {

    private final String taskName;
    private boolean TaskExecuted;
    private final String whatToBuy;
    private final double quantity;

    ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.TaskExecuted = false;
    }

    @Override
    public Task executeTask() {
        this.TaskExecuted = true;
        return this;
    }
}
