package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollector {
    private List<Shape> shapeCollection = new ArrayList<>();

    void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }

    boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapeCollection.contains(shape)) {
            shapeCollection.remove(shape);
            result=true;
        }
        return result;
    }

    Shape getFigure(int n) {
        return shapeCollection.get(n);
    }

    int getQuantity(){
        return shapeCollection.size();
    }

    String showFigures() {
        StringBuilder sb=new StringBuilder();

        for (Shape shape : shapeCollection) {
            sb.append(shape.getShapeName())
                    .append(" ");
        }
        String result = sb.toString();
        return result;
    }

}
