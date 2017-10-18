package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {


    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;
    private final Board board;

    public BoardConfig(@Qualifier("toDoList") TaskList toDoList, @Qualifier("inProgressList") TaskList inProgressList, @Qualifier("doneList") TaskList doneList, @Qualifier("board") Board board) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
        this.board = board;
    }

    @Bean(name = "toDoList")
    @Qualifier("toDoList")
    public TaskList getToDoList() {
        return toDoList;
    }

    @Bean(name = "inProgressList")
    @Qualifier("inProgressList")
    public TaskList getInProgressList() {
        return inProgressList;
    }

    @Bean(name = "doneList")
    @Qualifier("doneList")
    public TaskList getDoneList() {
        return doneList;
    }

    @Bean(name = "board")
    @Qualifier("board")
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getToDoList());
    }
}