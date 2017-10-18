package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public BoardConfig(@Qualifier("toDoList") TaskList toDoList, @Qualifier("inProgressList") TaskList inProgressList, @Qualifier("doneList") TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    @Bean(name = "toDoList")
    @Qualifier("toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return toDoList;
    }

    @Bean(name = "inProgressList")
    @Qualifier("inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return inProgressList;
    }

    @Bean(name = "doneList")
    @Qualifier("doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return doneList;
    }

    @Bean(name = "board")
    @Qualifier("board")
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getToDoList());
    }
}