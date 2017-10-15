package com.kodilla.spring.portfolio;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Setter
public class BoardConfig {
    @Autowired
    private List<TaskList> taskList;

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return taskList.get(0);
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return taskList.get(1);
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return taskList.get(2);
    }

    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}