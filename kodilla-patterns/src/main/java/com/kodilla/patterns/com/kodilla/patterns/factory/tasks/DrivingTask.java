package com.kodilla.patterns.com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class DrivingTask implements Task {

    private final String taskName;
    private boolean TaskExecuted;
    private final String where;
    private final String using;

    DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.TaskExecuted = false;
    }

    @Override
    public Task executeTask() {
        this.TaskExecuted = true;
        return this;
    }
}
