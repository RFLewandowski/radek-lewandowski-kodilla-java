package com.kodilla.good.patterns.challenges.secondChallenge.repository;

import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.User;

import java.util.Map;

public class DummyOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Map<String, Integer> products) {
        System.out.println(">>Zamówienie użytkownika "+user.getUsername()+" dodane do bazy.");
    }
}
