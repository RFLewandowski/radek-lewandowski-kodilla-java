package com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing;

import com.kodilla.good.patterns.challenges.secondChallenge.DTO.OrderDto;
import com.kodilla.good.patterns.challenges.secondChallenge.informationService.InformationService;
import com.kodilla.good.patterns.challenges.secondChallenge.orderService.OrderService;
import com.kodilla.good.patterns.challenges.secondChallenge.repository.OrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProducts());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProducts());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}