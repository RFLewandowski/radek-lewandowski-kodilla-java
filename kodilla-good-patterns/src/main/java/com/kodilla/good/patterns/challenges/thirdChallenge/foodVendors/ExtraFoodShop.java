package com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors;

import com.kodilla.good.patterns.challenges.thirdChallenge.dto.WaybillDTO;
import lombok.Value;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Value
public class ExtraFoodShop implements FoodVendor {

    private static final String VENDOR_ID = "ExtraFoodShop";
    Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("pomidorki", 3);
        put("ogórki", 2);
    }};

    @Override
    public String getVendorId() {
        return VENDOR_ID;
    }

    @Override
    public WaybillDTO process(Map<String, Integer> orderedProducts) {
        LocalDate dateOfDelivery = LocalDate.now().plusDays(30);
        return new WaybillDTO(VENDOR_ID, true, dateOfDelivery, orderedProducts);
    }
}
