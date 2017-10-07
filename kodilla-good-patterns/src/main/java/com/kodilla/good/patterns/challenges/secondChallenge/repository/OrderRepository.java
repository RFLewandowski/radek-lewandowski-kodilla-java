package com.kodilla.good.patterns.challenges.secondChallenge.repository;

import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.User;

import java.util.Map;

public interface OrderRepository {
    void createOrder(User user, Map<String, Integer> products);
}
