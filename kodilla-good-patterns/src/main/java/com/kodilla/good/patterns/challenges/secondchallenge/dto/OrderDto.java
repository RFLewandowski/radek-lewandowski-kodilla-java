package com.kodilla.good.patterns.challenges.secondchallenge.dto;

import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.User;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor //added because seems that sometimes @Value annotation doesn't create this constructoro
public class OrderDto {
    private User user;
    private boolean isOrdered;
}