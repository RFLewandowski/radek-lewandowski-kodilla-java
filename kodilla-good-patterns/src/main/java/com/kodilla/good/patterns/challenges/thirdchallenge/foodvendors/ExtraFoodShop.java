package com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors;

import com.kodilla.good.patterns.challenges.thirdchallenge.dto.WaybillDTO;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = false)
@Value
public class ExtraFoodShop extends AbstractFoodVendor {

    private static final String VENDOR_ID = "ExtraFoodShop";
    Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("pomidorki", 3);
        put("ogorki", 2);
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
