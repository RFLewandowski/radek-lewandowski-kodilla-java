package com.kodilla.good.patterns.challenges.secondchallenge;

import com.kodilla.good.patterns.challenges.secondchallenge.informationservice.DummyInformationService;
import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.OrderProcessor;
import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.OrderRequest;
import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.secondchallenge.orderservice.DummyOrderService;
import com.kodilla.good.patterns.challenges.secondchallenge.repository.DummyOrderRepository;

public class App {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        DummyInformationService dummyInformationService = new DummyInformationService();
        DummyOrderService dummyOrderService = new DummyOrderService();
        DummyOrderRepository dummyOrderRepository = new DummyOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(
                dummyInformationService,dummyOrderService,dummyOrderRepository);
        orderProcessor.process(orderRequest);
    }
}