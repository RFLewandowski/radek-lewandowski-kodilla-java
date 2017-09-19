package com.kodilla.exception.test;

public class ExceptionHandling{
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(10,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Seems it is really whole second task");
        }
    }
}
