package com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing;

import com.kodilla.good.patterns.challenges.secondchallenge.dto.OrderDto;
import com.kodilla.good.patterns.challenges.secondchallenge.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.secondchallenge.orderservice.OrderService;
import com.kodilla.good.patterns.challenges.secondchallenge.repository.OrderRepository;
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