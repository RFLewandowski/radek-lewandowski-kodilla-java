package com.kodilla.spring.intro.shape;

import org.junit.Assert;
import org.junit.Test;

public class DrawerTestSuite {
    @Test
    public void Should_drawCircle() {
        //Given
        Circle circle = new Circle();
        Drawer drawer = new Drawer(circle);
        //When
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a circle", result);
    }


    @Test
    public void Should_drawTriangle() {
        //Given
        Triangle triangle = new Triangle();
        Drawer drawer = new Drawer(triangle);
        //When
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a triangle", result);
    }
}