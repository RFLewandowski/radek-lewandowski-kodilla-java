package com.kodilla.spring.portfolio;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void Should_InitializeBoard(){
        //Given
        List<String> toDoTasks = Arrays.asList("testToDo");
        List<String> inProgressTasks = Arrays.asList("testInProgress");
        List<String> doneTasks = Arrays.asList("testDoneTask");

        TaskList toDoList = new TaskList(toDoTasks);
        TaskList inProgressList = new TaskList(inProgressTasks);
        TaskList doneList = new TaskList(doneTasks);

        //When
        Board board = new Board(toDoList,inProgressList,doneList);
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
