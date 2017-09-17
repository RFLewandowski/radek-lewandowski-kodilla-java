package com.kodilla.stream.invoice.simple;

import lombok.Value;

@Value
public class SimpleItem {
    SimpleProduct product;
    double quantity;

    public double getValue() {
        return product.getProductPrice() * quantity;
    }
}
