package com.kodilla.good.patterns.challenges.secondChallenge;

import java.util.Map;

public interface OrderRepository {
    void createOrder(User user, Map<String, Integer> products);
}
