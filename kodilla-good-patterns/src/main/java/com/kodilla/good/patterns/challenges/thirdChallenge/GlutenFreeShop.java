package com.kodilla.good.patterns.challenges.thirdChallenge;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class GlutenFreeShop implements FoodVendor {
    @Override
    public String getVendorId() {
        return null;
    }

    @Override
    public Map<String, Integer> getProducts() {
        return null;
    }

    @Override
    public WaybillDTO process(Map<String, Integer> orderedProducts) {
        return null;
    }
}
