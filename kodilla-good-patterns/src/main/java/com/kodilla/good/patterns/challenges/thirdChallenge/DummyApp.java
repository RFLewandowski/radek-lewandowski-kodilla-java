package com.kodilla.good.patterns.challenges.thirdChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class DummyApp {
//"Załóż, że całość systemu poza tym, co zostało zawarte w powyższych punktach jest nieistotna"

    public static void main(String[] args) {
        List<FoodVendor> fv = new ArrayList<>();
        Collections.addAll(fv, new HealthyShop(), new GlutenFreeShop(), new ExtraFoodShop());

        for (FoodVendor foodVendor : fv) {
            String vendorID = foodVendor.getVendorId();
            System.out.println(vendorID + "może dostarczyć: \n");

            Map vendorsProductsMap = foodVendor.getProducts();
            String vendorsProducts = Arrays.toString(new Map[]{vendorsProductsMap});
            System.out.println(vendorsProducts);
            System.out.println("\n");
        }

        for (FoodVendor foodVendor : fv) {
            String vendorID = foodVendor.getVendorId();
            System.out.println(vendorID + ">>zamówienie pomidorków: \n");
            Map<String, Integer> pomidorki = new HashMap<>();
            pomidorki.put("pomidorki", 2);
            WaybillDTO wbdto = foodVendor.process(pomidorki);
            System.out.println(wbdto.toString());
        }
    }
}
