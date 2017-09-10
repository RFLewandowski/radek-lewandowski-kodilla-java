package com.kodilla.testing.shape;

import lombok.NonNull;
import lombok.Value;

@Value
public class Square implements Shape {

    @NonNull
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
