package com.kodilla.good.patterns.challenges.secondchallenge.repository;

import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.User;

import java.util.Map;

public interface OrderRepository {
    void createOrder(User user, Map<String, Integer> products);
}
