package com.kodilla.good.patterns.challenges.thirdchallenge;

import com.kodilla.good.patterns.challenges.thirdchallenge.dto.WaybillDTO;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.FoodVendor;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.GlutenFreeShop;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShopTestSuite {
    @Test
    public void Should_ProcessPresentProducts() {
        //Given
        FoodVendor foodVendor = new GlutenFreeShop();
        String expectedProducts = "{pierozki bezglutenowe=3}";
        //When
        Map vendorsProductsMap = foodVendor.getProducts();
        String vendorsProducts = vendorsProductsMap.toString();
        //Then
        Assert.assertEquals(expectedProducts, vendorsProducts);
    }

    @Test
    public void Should_ReturnWhatCanProvide() {
        //Given
        FoodVendor foodVendor = new GlutenFreeShop();
        Map<String, Integer> pierozki = new HashMap<>();
        pierozki.put("pierozki bezglutenowe", 2);

        LocalDate ld = LocalDate.now().plusDays(2);
        WaybillDTO expectedWaybill = new WaybillDTO("GlutenFreeShop", true, ld, pierozki);

        //When
        WaybillDTO actualWaybill = foodVendor.process(pierozki);

        //Then
        Assert.assertEquals(expectedWaybill, actualWaybill);
    }
}
