package com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors;

import java.util.Map;

public abstract class AbstractFoodVendor implements FoodVendor {

    boolean isInStore(Map<String, Integer> orderedProducts) {
        for (String s : orderedProducts.keySet()) {
            try {
                if (isAvailable(s, orderedProducts)) ;
                else return false;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean isAvailable(String s, Map<String, Integer> orderedProducts) {
        if (getProducts().containsKey(s) && getProducts().get(s) >= orderedProducts.get(s)) return true;
        else return false;
    }
}