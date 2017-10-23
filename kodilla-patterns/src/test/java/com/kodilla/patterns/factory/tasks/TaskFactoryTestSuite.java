package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory = new TaskFactory();
    private Task driving = taskFactory.scheduleTask(TaskFactory.DRIVING_TASK);
    private Task painting = taskFactory.scheduleTask(TaskFactory.PAINTING_TASK);
    private Task shopping = taskFactory.scheduleTask(TaskFactory.SHOPPING_TASK);

    @Test
    public void Should_scheduleDriving() {
        //Given and When

        //Then
        Assert.assertEquals("trip", driving.getTaskName());
        Assert.assertEquals(false, driving.isTaskExecuted());
    }

    @Test
    public void Should_schedulePainting() {
        //Given and When

        //Then
        Assert.assertEquals("paint car", painting.getTaskName());
        Assert.assertEquals(false, painting.isTaskExecuted());
    }

    @Test
    public void Should_scheduleShopping() {
        //Given and When

        //Then
        Assert.assertEquals("groceries", shopping.getTaskName());
        Assert.assertEquals(false, shopping.isTaskExecuted());
    }


    @Test
    public void Should_executeDriving() {
        //Given and When
        driving.executeTask();

        //Then
        Assert.assertEquals("trip", driving.getTaskName());
        Assert.assertEquals(true, driving.isTaskExecuted());
    }

    @Test
    public void Should_executePainting() {
        //Given and When
        painting.executeTask();

        //Then
        Assert.assertEquals("paint car", painting.getTaskName());
        Assert.assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    public void Should_executeShopping() {
        //Given and When
        shopping.executeTask();

        //Then
        Assert.assertEquals("groceries", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }

}
