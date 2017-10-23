package com.kodilla.spring.portfolio;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class TaskList {
    List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
}