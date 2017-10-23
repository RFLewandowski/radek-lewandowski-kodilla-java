package com.kodilla.patterns.factory.tasks;

import lombok.Getter;

@Getter
public class PaintingTask extends AbstractTask {

   // private final String taskName;
   // private boolean TaskExecuted;
    private final String color;
    private final String whatToPaint;

    PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.TaskExecuted = false;
    }
}
