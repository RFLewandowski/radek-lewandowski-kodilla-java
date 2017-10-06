package com.kodilla.good.patterns.challenges.secondChallenge;

import java.util.Arrays;
import java.util.Map;

public class DummyOrderService implements OrderService {
    @Override
    public boolean order(User user, Map<String, Integer> products) {
        System.out.println(">>Spakujcie :");

        String basket = Arrays.toString(new Map[]{products});
        System.out.println(basket);
        System.out.println(" i wyslijcie do " + user.getUsername() + "\n");

        return true;
    }
}
