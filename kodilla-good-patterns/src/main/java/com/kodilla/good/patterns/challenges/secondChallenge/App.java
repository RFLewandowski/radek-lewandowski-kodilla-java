package com.kodilla.good.patterns.challenges.secondChallenge;

public class App {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new DummyInformationService(), new DummyOrderService(), new DummyOrderRepository());
        orderProcessor.process(orderRequest);
    }
}