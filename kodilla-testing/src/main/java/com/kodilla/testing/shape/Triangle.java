package com.kodilla.testing.shape;

import lombok.NonNull;
import lombok.Value;

@Value
public class Triangle implements Shape {

    @NonNull
    int base;
    @NonNull
    int height;

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return base*height/2;
    }

}
