package com.kodilla.good.patterns.challenges.thirdChallenge.dto;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.Map;

@Value
public class WaybillDTO {

    @NonNull
    private String FoodVendorID;
    @NonNull
    private Boolean isOrdered;
    private LocalDate dateOfDelivery;
    private Map<String, Integer> orderedProducts;
}
