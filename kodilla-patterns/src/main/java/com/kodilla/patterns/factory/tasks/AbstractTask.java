package com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class AbstractTask implements Task {
    protected String taskName;
    protected boolean TaskExecuted;

    public Task executeTask() {
        this.TaskExecuted = true;
        return this;
    }
}
