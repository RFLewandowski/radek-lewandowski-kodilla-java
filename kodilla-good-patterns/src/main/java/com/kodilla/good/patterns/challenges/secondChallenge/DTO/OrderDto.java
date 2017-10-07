package com.kodilla.good.patterns.challenges.secondChallenge.DTO;

import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.User;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor //added because seems that sometimes @Value annotation doesn't create this constructoro
public class OrderDto {
    private User user;
    private boolean isOrdered;
}