package com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class DrivingTask extends AbstractTask {
    private final String where;
    private final String using;

    DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.TaskExecuted = false;
    }
}
