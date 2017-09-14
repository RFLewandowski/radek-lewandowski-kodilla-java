package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Gniew bogini Achilla głoś obfity w szkody..", (a) -> "ABC" + a + "ABC");
        poemBeautifier.beautify("Gniew bogini Achilla głoś obfity w szkody..", (a) -> a.toUpperCase());
        poemBeautifier.beautify("Gniew bogini Achilla głoś obfity w szkody..", (a) -> a.replace('o', '~'));
        poemBeautifier.beautify("Gniew bogini Achilla głoś obfity w szkody..", (a) -> a.toLowerCase());

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }
}