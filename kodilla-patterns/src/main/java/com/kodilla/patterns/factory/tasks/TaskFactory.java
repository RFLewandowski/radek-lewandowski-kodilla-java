package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "ShoppingTask";
    public static final String PAINTING_TASK = "PaintingTask";
    public static final String DRIVING_TASK = "DrivingTask";


    public final Task scheduleTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("groceries", "tomato", 2);
            case PAINTING_TASK:
                return new PaintingTask("paint car", "black", "car");
            case DRIVING_TASK:
                return new DrivingTask("trip", "Tokio", "car");
            default:
                return null;
        }
    }
}
