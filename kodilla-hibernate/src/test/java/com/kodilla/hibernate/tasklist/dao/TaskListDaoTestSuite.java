package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;
    private static final String TASKLIST_NAME = "testTaskListName";
    private static final String TASKLIST_DESCRIPTION = "testTaskListDescription";
    private static final String TASK_DESCRIPTION_1 = "Test: Learn Hibernate";
    private static final String TASK_DESCRIPTION_2 = "Test: Write some entities";



    @Test
    public void Should_FindTaskListByName() {
        //Given
        TaskList taskList = new TaskList(TASKLIST_NAME, TASKLIST_DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> resultTaskList = taskListDao.findByListName(TASKLIST_NAME);

        //Then
        Assert.assertEquals(1, resultTaskList.size());

        //CleanUp
        int resultId = resultTaskList.get(0).getId();
        taskListDao.delete(resultId);
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task(TASK_DESCRIPTION_1, 14);
        Task task2 = new Task(TASK_DESCRIPTION_2, 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(TASKLIST_NAME, TASKLIST_DESCRIPTION);
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDao.delete(id);
    }
}
