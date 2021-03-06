package com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing;

import lombok.Value;

import java.util.Map;

@Value
public class OrderRequest {
    private User user;
    private Map<String, Integer> products;//key product, value quantity
}
