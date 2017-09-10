package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }


    @Test
    public void testAddFigureCircle() {
        //Given
        Shape testCircle = new Circle(2);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(testCircle);
        //Then
        Assert.assertEquals(1, shapeCollector.getQuantity());
    }


    @Test
    public void testAddFigureSquare() {
        //Given
        Shape testSquare = new Square(3);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(testSquare);
        //Then
        Assert.assertEquals(1, shapeCollector.getQuantity());
    }

    @Test
    public void testAddFigureTriangle() {
        //Given
        Shape testTriangle = new Triangle(4, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(testTriangle);
        //Then
        Assert.assertEquals(1, shapeCollector.getQuantity());
    }


    @Test
    public void testRemoveFigure() {
        //Given
        Shape testTriangle = new Triangle(4, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(testTriangle);
        //When
        shapeCollector.removeFigure(testTriangle);
        //Then
        Assert.assertEquals(0, shapeCollector.getQuantity());
    }

    @Test
    public void testRemoveFigureFromEmptyList()testRemoveFigureFromEmptyList() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Boolean result =shapeCollector.removeFigure(new Triangle(1,1));
        //Then
        Assert.assertFalse(result);
    }


    @Test
    public void testGetFigure() {
        //Given
        Shape testTriangle = new Triangle(4, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(testTriangle);
        //When
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertTrue(result instanceof Triangle);
    }


    @Test
    public void showFigures() {
        //Given
        Shape testTriangle = new Triangle(4, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(testTriangle);
        String expectedName = "triangle ";
        //When
        String figureNames = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(expectedName, figureNames);
    }
}
