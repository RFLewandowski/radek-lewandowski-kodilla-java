package com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors;

import com.kodilla.good.patterns.challenges.thirdchallenge.dto.WaybillDTO;

import java.util.Map;

public interface FoodVendor {
    String getVendorId();

    Map<String, Integer> getProducts();

    WaybillDTO process(Map<String, Integer> orderedProducts);
}