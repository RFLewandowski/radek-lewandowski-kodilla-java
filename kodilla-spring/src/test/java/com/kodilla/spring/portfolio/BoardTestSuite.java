package com.kodilla.spring.portfolio;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Autowired
    TaskList toDoList;
    @Autowired
    TaskList inProgressList;
    @Autowired
    TaskList doneList;
    @Autowired
    Board board;


    @Test
    public void Should_InitializeBoard() {
        //Given
        List<String> toDoTasks = Arrays.asList("testToDo");
        List<String> inProgressTasks = Arrays.asList("testInProgress");
        List<String> doneTasks = Arrays.asList("testDoneTask");

        toDoList.setTasks(toDoTasks);
        inProgressList.setTasks(inProgressTasks);
        doneList.setTasks(doneTasks);

        //When
        board.setToDoList(toDoList);
        board.setToDoList(inProgressList);
        board.setToDoList(doneList);

        //Then
        System.out.println(toDoTasks);
        System.out.println(inProgressTasks);
        System.out.println(doneTasks);

        System.out.println(toDoList.toString());
        System.out.println(inProgressList.toString());
        System.out.println(doneList.toString());

        System.out.println(board.toString());
    }
}
