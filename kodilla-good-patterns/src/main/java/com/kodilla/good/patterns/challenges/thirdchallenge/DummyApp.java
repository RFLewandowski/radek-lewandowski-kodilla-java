package com.kodilla.good.patterns.challenges.thirdchallenge;

import com.kodilla.good.patterns.challenges.thirdchallenge.demo.FoodVendorPresenter;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.FoodVendor;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.HealthyShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DummyApp {

    public static void main(String[] args) {
        List<FoodVendor> fv = new ArrayList<>();
        Collections.addAll(fv, new HealthyShop(), new GlutenFreeShop(), new ExtraFoodShop());

        for (FoodVendor foodVendor : fv) {
            FoodVendorPresenter presentingVendor = new FoodVendorPresenter();
            presentingVendor.whatCanProvide(foodVendor);
            presentingVendor.testOrder(foodVendor);
        }
    }
}
