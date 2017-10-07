package com.kodilla.good.patterns.challenges.secondChallenge;

import com.kodilla.good.patterns.challenges.secondChallenge.informationService.DummyInformationService;
import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.OrderProcessor;
import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.OrderRequest;
import com.kodilla.good.patterns.challenges.secondChallenge.orderProcessing.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.secondChallenge.orderService.DummyOrderService;
import com.kodilla.good.patterns.challenges.secondChallenge.repository.DummyOrderRepository;

public class App {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new DummyInformationService(), new DummyOrderService(), new DummyOrderRepository());
        orderProcessor.process(orderRequest);
    }
}