package com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors;

import com.kodilla.good.patterns.challenges.thirdchallenge.dto.WaybillDTO;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = false)
@Value
public class HealthyShop extends AbstractFoodVendor {

    private static final String VENDOR_ID = "HealthyShop";
    Map<String, Integer> products = new HashMap<String, Integer>() {{
        put("pomidorki", 3);
        put("rzodkiewki", 2);
    }};

    @Override
    public String getVendorId() {
        return VENDOR_ID;
    }

    public WaybillDTO process(Map<String, Integer> orderedProducts) {
        if (this.isInStore(orderedProducts)) {
            LocalDate dateOfDelivery = getDeliveryDate();
            return new WaybillDTO(VENDOR_ID, true, dateOfDelivery, orderedProducts);
        }
        return new WaybillDTO(VENDOR_ID, false, null, null);
    }

    private LocalDate getDeliveryDate() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }
}
