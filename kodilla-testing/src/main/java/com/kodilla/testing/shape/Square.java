package com.kodilla.testing.shape;

import lombok.Value;

@Value
public class Square implements Shape {

    int side;

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return side*side;
    }
}
