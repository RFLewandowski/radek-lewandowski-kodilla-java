package com.kodilla.testing.shape;

import lombok.Value;

@Value
public class Triangle implements Shape {

    int base;
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
