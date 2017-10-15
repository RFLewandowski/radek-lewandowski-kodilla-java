package com.kodilla.spring.portfolio;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Setter
public class BoardConfig {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    @Autowired
    public BoardConfig(TaskList toDoList,TaskList inProgressList,TaskList doneList) {
        this.toDoList = toDoList;
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return toDoList;
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return inProgressList;
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return doneList;
    }

    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}