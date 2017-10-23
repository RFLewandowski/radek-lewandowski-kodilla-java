package com.kodilla.spring.portfolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@AllArgsConstructor
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;
}