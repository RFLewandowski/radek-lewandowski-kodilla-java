package com.kodilla.good.patterns.challenges.thirdChallenge;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Map;

public class WaybillDTO {

    @NonNull
    private String FoodVendorID;
    @NonNull
    private Boolean isOrdered;
    private LocalDate dateOfDelivery;
    private Map<String, Integer> orderedProducts;
}
