package com.kodilla.spring.portfolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;
}
