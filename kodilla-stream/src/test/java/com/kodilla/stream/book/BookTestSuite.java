package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    //TODO Tutaj mamy klasę, w której dzieje się dużo pod maską, a dane testowe są tightly coupled z kodem testowanej klasy. BookDirectory de fakto jest testową klasą wspomagającą - więc to co jest uruchamiane w jej konstruktorze (ładowanie danych) przenieśmy do jakiejś klasy typu BookDirectoryAssembler, która będzie w pakiecie test, i jeśli chcemy tych danych używać, to jawnie wywołajmy BookDirectoryAssembler.assemble() która nam zwróci BookDirectory uzupełniony danymi, których potrzebujemy.
    @Test
    public void should_getYearOfPublication() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void should_getListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream
                .range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}