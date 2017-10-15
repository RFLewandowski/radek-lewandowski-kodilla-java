package com.kodilla.spring.portfolio;

import lombok.Value;

@Value
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;
}
