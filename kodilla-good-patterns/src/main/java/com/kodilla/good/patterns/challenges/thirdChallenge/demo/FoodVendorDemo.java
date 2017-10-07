package com.kodilla.good.patterns.challenges.thirdChallenge.demo;

import com.kodilla.good.patterns.challenges.thirdChallenge.dto.WaybillDTO;
import com.kodilla.good.patterns.challenges.thirdChallenge.foodVendors.FoodVendor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FoodVendorDemo {


    public void whatCanProvide(FoodVendor foodVendor) {
        String vendorID = foodVendor.getVendorId();
        System.out.println(vendorID + "może dostarczyć:");

        Map vendorsProductsMap = foodVendor.getProducts();
        String vendorsProducts = vendorsProductsMap.toString();
        System.out.println(vendorsProducts);
        System.out.println("\n");
    }

    public void testOrder(FoodVendor foodVendor) {
        String vendorID = foodVendor.getVendorId();
        System.out.println(vendorID + ">>zamówienie pomidorków:");
        Map<String, Integer> pomidorki = new HashMap<>();
        pomidorki.put("pomidorki", 2);

        WaybillDTO wbdto = foodVendor.process(pomidorki);
        System.out.println(wbdto.toString());
        System.out.println("\n");
    }
}
