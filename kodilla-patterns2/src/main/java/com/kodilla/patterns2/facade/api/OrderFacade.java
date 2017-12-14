package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class OrderFacade {
    private final ShopService shopService;

    @Autowired
    public OrderFacade(ShopService shopService) {
        this.shopService = shopService;
    }

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        log.info("Registering new order, ID: " + orderId);
        if (orderId < 0) {
            log.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem : order.getItems()) {
                log.info("Adding item " + orderItem.getProductId() + ", " +
                        orderItem.getQuantity() + " pcs");
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            log.info("Order valuse is: " + value + " USD");
            if (!shopService.doPayment(orderId)) {
                log.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            log.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                log.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            log.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                log.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            log.info("Order " + orderId + " submitted");
        } finally {
            if (wasError) {
                log.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}