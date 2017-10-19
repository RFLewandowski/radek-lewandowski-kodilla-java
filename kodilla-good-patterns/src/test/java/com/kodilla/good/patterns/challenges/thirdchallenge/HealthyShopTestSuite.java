package com.kodilla.good.patterns.challenges.thirdchallenge;

import com.kodilla.good.patterns.challenges.thirdchallenge.dto.WaybillDTO;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.FoodVendor;
import com.kodilla.good.patterns.challenges.thirdchallenge.foodvendors.HealthyShop;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HealthyShopTestSuite {
    @Test
    public void Should_ProcessPresentProducts() {
        //Given
        FoodVendor foodVendor = new HealthyShop();
        String expectedProducts = "{pomidorki=3, rzodkiewki=2}";
        //When
        Map vendorsProductsMap = foodVendor.getProducts();
        String vendorsProducts = vendorsProductsMap.toString();
        //Then
        Assert.assertEquals(expectedProducts, vendorsProducts);
    }

    @Test
    public void Should_ReturnWhatCanProvide() {
        //Given
        FoodVendor foodVendor = new HealthyShop();
        Map<String, Integer> pomidorki = new HashMap<>();
        pomidorki.put("pomidorki", 2);

        LocalDate ld = LocalDate.now().plusDays(1);
        WaybillDTO expectedWaybill = new WaybillDTO("HealthyShop", true, ld, pomidorki);

        //When
        WaybillDTO actualWaybill = foodVendor.process(pomidorki);

        //Then
        Assert.assertEquals(expectedWaybill, actualWaybill);
    }
}
