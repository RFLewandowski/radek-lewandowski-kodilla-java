package com.kodilla.spring.portfolio;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private TaskList toDoList;
    @Autowired
    private TaskList inProgressList;
    @Autowired
    private TaskList doneList;
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

        //toDoList.getTasks().add("testToDo");
        //inProgressList.getTasks().add("testInProgress");
        //doneList.getTasks().add("testDoneTask");

        //When
        //board.setToDoList(toDoList);
        //board.setInProgressList(inProgressList);
        //board.setDoneList(doneList);

        //Then
        System.out.println(toDoTasks);
        System.out.println(inProgressTasks);
        System.out.println(doneTasks);

        System.out.println(toDoList.toString());
        System.out.println(inProgressList.toString());
        System.out.println(doneList.toString());

        System.out.println(board.toString());
    }

    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
