package com.kodilla.testing.shape;

import lombok.NonNull;
import lombok.Value;

@Value
public class Circle implements Shape {

    @NonNull
    int radius;

    @Override
    public String getShapeName() {
        return "circle";
    }

    @Override
    public double getField() {
        Double result = Math.PI*radius;
        result=Math.round( result * 100.0 ) / 100.0;
        return result;
    }
}
