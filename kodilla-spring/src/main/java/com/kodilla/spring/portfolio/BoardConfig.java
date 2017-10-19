package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    //@Qualifier("toDoList") TODO rozwikłąć zagadkę czemu to powoduje, że bean jest nullem, albo napisać od początku
    public TaskList toDoList;
    @Autowired
    //@Qualifier("inProgressList")
    public TaskList inProgressList;
    @Autowired
    //@Qualifier("doneList")
    public TaskList doneList;
//    //private Board board;

//    public BoardConfig(@Qualifier("toDoList") TaskList toDoList, @Qualifier("inProgressList") TaskList inProgressList, @Qualifier("doneList") TaskList doneList) {
//        this.toDoList = toDoList;
//        this.inProgressList = inProgressList;
//        this.doneList = doneList;
//        //this.board = new Board(getToDoList(), getInProgressList(), getToDoList());
//    }

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
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}