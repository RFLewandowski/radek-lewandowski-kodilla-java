package com.kodilla.good.patterns.challenges.thirdChallenge;

import java.util.Map;

interface FoodVendor {
    String getVendorId();

    Map<String, Integer> getProducts();

    WaybillDTO process(Map<String, Integer> orderedProducts);
}