package com.kodilla.exception.challenge;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = 0;
        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("It is whole task:D");
        }

        System.out.println(result);

    }
}