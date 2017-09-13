package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String poem, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(poem);
        System.out.println("Result equals: " + result);
    }
}
