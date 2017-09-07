package com.kodilla.testing.collection;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OddNumbersExterminator {

    ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if ((number % 2 == 0) && (number != 0)) result.add(number);
        }

        return result;
    }
}
