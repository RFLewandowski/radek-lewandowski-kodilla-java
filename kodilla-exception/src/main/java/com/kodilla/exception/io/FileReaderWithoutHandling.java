package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {
    public void readFile() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        Stream<String> fileLines = Files.lines(file.toPath());
        fileLines.forEach(System.out::println);


    }
}