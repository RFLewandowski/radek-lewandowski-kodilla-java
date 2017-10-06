package com.kodilla.good.patterns.challenges.secondChallenge;

import java.util.Map;

public interface OrderService {
    boolean order(User user, Map<String, Integer> products);
}