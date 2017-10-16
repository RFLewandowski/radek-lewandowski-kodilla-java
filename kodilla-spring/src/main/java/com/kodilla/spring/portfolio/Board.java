package com.kodilla.spring.portfolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;
}
