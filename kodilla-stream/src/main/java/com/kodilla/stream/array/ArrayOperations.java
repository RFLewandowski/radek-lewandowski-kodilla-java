package com.kodilla.stream.array;

import lombok.NonNull;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static OptionalDouble getAverage(@NonNull int[] numbers) {

        IntStream
                .range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        OptionalDouble result = IntStream
                .range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average();


                if (result.isPresent()) {
                        return result;
                    } else {
                        throw new IllegalArgumentException("Probably numbers array is empty");
                }
    }
}
