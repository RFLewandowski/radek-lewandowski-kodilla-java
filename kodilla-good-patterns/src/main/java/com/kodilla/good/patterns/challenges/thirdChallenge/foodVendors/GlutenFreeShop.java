package com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors;

import com.kodilla.good.patterns.challenges.thirdChallenge.dto.WaybillDTO;
import lombok.Value;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Value
public class GlutenFreeShop implements FoodVendor {

    private static final String VENDOR_ID = "GlutenFreeShop";
    Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("pierożki bezglutenowe", 3);
    }};

    @Override
    public String getVendorId() {
        return VENDOR_ID;
    }

    @Override
    public WaybillDTO process(Map<String, Integer> orderedProducts) {
        if (FoodVendor.isInStore(orderedProducts, products)) {
            LocalDate dateOfDelivery = LocalDate.now().plusDays(2);
            return new WaybillDTO(VENDOR_ID, true, dateOfDelivery, orderedProducts);
        }
        return new WaybillDTO(VENDOR_ID, false, null, null);
    }
}
