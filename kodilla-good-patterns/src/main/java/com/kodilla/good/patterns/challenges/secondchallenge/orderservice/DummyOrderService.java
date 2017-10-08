package com.kodilla.good.patterns.challenges.secondchallenge.orderservice;

import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.User;

import java.util.Map;

public class DummyOrderService implements OrderService {
    @Override
    public boolean order(User user, Map<String, Integer> products) {
        System.out.println(">>Spakujcie :");

        String basket = products.toString();
        System.out.println(basket);
        System.out.println(" i wyslijcie do " + user.getUsername() + "\n");

        return true;
    }
}
