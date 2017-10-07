package com.kodilla.good.patterns.challenges.thirdChallenge;

import com.kodilla.good.patterns.challenges.thirdChallenge.demo.FoodVendorDemo;
import com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors.FoodVendor;
import com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors.HealthyShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DummyApp {

    public static void main(String[] args) {
        List<FoodVendor> fv = new ArrayList<>();
        Collections.addAll(fv, new HealthyShop(), new GlutenFreeShop(), new ExtraFoodShop());

        for (FoodVendor foodVendor : fv) {
            FoodVendorDemo presentingVendor = new FoodVendorDemo();
            presentingVendor.whatCanProvide(foodVendor);
            presentingVendor.testOrder(foodVendor);
        }
    }
}
