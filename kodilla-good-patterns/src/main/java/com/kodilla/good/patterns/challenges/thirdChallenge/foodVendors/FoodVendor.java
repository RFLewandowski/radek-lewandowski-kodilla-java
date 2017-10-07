package com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors;

import com.kodilla.good.patterns.challenges.thirdChallenge.dto.WaybillDTO;

import java.util.Map;

public interface FoodVendor {
    String getVendorId();

    Map<String, Integer> getProducts();

    WaybillDTO process(Map<String, Integer> orderedProducts);

    static boolean isInStore(Map<String, Integer> orderedProducts, Map<String, Integer> products) {
        for (String s : orderedProducts.keySet()) {
            try {
                if (products.containsKey(s) && products.get(s) >= orderedProducts.get(s)) ;
                else return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}