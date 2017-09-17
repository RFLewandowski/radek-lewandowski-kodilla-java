package com.kodilla.stream.invoice.simple;

import lombok.Value;

@Value
public final class SimpleProduct {
    String productName;
    double productPrice;
}