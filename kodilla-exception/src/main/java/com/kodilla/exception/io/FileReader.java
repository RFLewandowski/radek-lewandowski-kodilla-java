package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());

        try (Stream<String> fileLines = Files.lines(file.toPath())){
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something went totally wrong!");
            throw new FileReaderException();
        }
        finally {
            System.out.println("Finally...");
        }


    }
}