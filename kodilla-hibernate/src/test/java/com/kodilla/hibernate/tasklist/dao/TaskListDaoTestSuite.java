package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;
    private static final String TASKLIST_NAME = "testTaskListName";
    private static final String TASKLIST_DESCRIPTION = "testTaskListDescription";

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
}
