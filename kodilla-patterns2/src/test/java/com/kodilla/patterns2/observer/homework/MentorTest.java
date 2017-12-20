package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class MentorTest {
    @Test
    public void Should_Update() throws Exception {
        //Given
        TraineesTasks traineeATasks = new TraineesTasks("Abacki");
        TraineesTasks traineeBTasks = new TraineesTasks("Babacki");

        Mentor mentorM = new Mentor("Mamamcki");
        Mentor mentorN = new Mentor("Namacki");


        traineeATasks.registerObserver(mentorM);
        traineeBTasks.registerObserver(mentorN);


        //When
        traineeATasks.addTask("task1");
        traineeATasks.addTask("task2");
        traineeATasks.addTask("task3");

        traineeBTasks.addTask("task1");
        traineeBTasks.addTask("task2");

        //Then
        Assert.assertEquals(3,mentorM.getUpdateCount());
        Assert.assertEquals(2,mentorN.getUpdateCount());
    }
}