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

    private boolean wasError = false;

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        long orderId = shopService.openOrder(userId);
        log.info("Registering new order, ID: " + orderId);
        validate(orderId < 0, OrderProcessingException.ERR_NOT_AUTHORISED);

        try {
            addItemsToOrder(orderId, order);
            BigDecimal value = shopService.calculateValue(orderId);
            log.info("Order valuse is: " + value + " USD");

            validate(shopService.verifyOrder(orderId), OrderProcessingException.ERR_PAYMENT_REJECTED);
            log.info("Payment for order was done");

            validate(shopService.verifyOrder(orderId), OrderProcessingException.ERR_VERIFICATION_ERROR);
            log.info("Order is ready to submit");

            validate(shopService.submitOrder(orderId), OrderProcessingException.ERR_SUBMITTING_ERROR);
            log.info("Order " + orderId + " submitted");

        } finally {
            if (wasError) {
                log.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }

    private void validate(boolean isProcessOk, String errorType) throws OrderProcessingException {
        if (!isProcessOk) {
            manageProcessingException(errorType);
        }
    }

    private void addItemsToOrder(long orderId, OrderDto order) {
        for (ItemDto orderItem : order.getItems()) {
            log.info("Adding item " + orderItem.getProductId() + ", " +
                    orderItem.getQuantity() + " pcs");
            shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
        }
    }

    private void manageProcessingException(String errorType) throws OrderProcessingException {
        log.error(errorType);
        wasError = true;
        throw new OrderProcessingException(errorType);
    }
}