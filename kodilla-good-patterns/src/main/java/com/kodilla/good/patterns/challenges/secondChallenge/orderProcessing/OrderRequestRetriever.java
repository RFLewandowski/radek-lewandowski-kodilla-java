package com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing;

import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("dummyUser", "dummyUser@dummy.co.uk");

        Map<String, Integer> products = new HashMap<>();
        products.put("pomidor", 2);
        products.put("ogórek", 2);
        products.put("rzodkiewka", 1);

        return new OrderRequest(user, products);
    }
}
