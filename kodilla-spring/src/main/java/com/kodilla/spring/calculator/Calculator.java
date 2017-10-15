package com.kodilla.spring.calculator;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Calculator {
    private final Display display;

    public double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double div(double a, double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }


}
