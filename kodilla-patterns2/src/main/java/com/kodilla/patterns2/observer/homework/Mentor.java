package com.kodilla.patterns2.observer.homework;


import lombok.Getter;

@Getter
public class Mentor implements TaskObserver {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TraineesTasks traineesTasks) {
        System.out.println(mentorName + ": New task in queue of trainee: " + traineesTasks.getTraineeName() + "\n" +
                " (total: " + traineesTasks.getTasks().size() + " tasks)");
        updateCount++;
    }
}
