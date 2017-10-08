package com.kodilla.good.patterns.challenges.secondchallenge.orderservice;

import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.User;

import java.util.Map;

public interface OrderService {
    boolean order(User user, Map<String, Integer> products);
}