package com.kodilla.patterns.builder.bigmac;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@AllArgsConstructor //addedd to supress intelij complains - should be added by @Value
public class Bigmac {
    private final String roll;
    private final int burgersQuantity;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String roll;
        private int burgersQuantity;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgersQuantity(int burgersQuantity) {
            this.burgersQuantity = burgersQuantity;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgersQuantity, sauce, ingredients);
        }
    }
}
