package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoList")
    @Qualifier("toDoList")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Qualifier("inProgressList")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Qualifier("doneList")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean(name = "board")
    @Qualifier("board")
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}