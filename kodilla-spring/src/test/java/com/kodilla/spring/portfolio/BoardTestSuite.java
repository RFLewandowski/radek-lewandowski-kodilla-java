package com.kodilla.spring.portfolio;

import org.junit.Assert;
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
    Board board;

    @Test
    public void Should_InitializeBoard() {
        //Given
        board.
                getToDoList()
                .getTasks()
                .add("testToDo");
        board.
                getInProgressList()
                .getTasks()
                .add("testInProgress");
        board
                .getDoneList()
                .getTasks()
                .add("testDoneTask");

        String expectedBoardString = "Board(toDoList=TaskList(tasks=[testToDo]), inProgressList=TaskList(tasks=[testInProgress]), doneList=TaskList(tasks=[testDoneTask]))";
        List<String> expectedToDo = Arrays.asList("testToDo");
        List<String> expectedInProgress = Arrays.asList("testInProgress");
        List<String> expectedDone = Arrays.asList("testDoneTask");

        //When
        List<String> actualToDo = board
                .getToDoList()
                .getTasks();
        List<String> actualInProgress = board
                .getInProgressList()
                .getTasks();
        List<String> actualDone = board
                .getDoneList()
                .getTasks();

        //Then
        Assert.assertEquals(expectedToDo, actualToDo);
        Assert.assertEquals(expectedInProgress, actualInProgress);
        Assert.assertEquals(expectedDone, actualDone);
        Assert.assertEquals(expectedBoardString, board.toString());
    }
}