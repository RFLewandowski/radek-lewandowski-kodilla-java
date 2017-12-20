package com.kodilla.patterns2.observer.homework;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TraineesTasks implements TaskObservable {
    private List<TaskObserver> taskObservers;
    private final List<String> tasks;
    private final String traineeName;

    public TraineesTasks(String traineeName) {
        this.taskObservers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.traineeName = traineeName;
    }


    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }


    @Override
    public void registerObserver(TaskObserver observer) {
        taskObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver observer : taskObservers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(TaskObserver observer) {
        taskObservers.remove(observer);
    }
}
