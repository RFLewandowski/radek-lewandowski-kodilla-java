package com.kodilla.good.patterns.challenges.secondChallenge.orderService;

import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.User;

import java.util.Map;

public interface OrderService {
    boolean order(User user, Map<String, Integer> products);
}