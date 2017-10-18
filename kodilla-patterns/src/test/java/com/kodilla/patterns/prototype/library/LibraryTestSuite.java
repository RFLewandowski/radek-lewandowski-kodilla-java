package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    Library originalLibrary = new Library("originalLibrary");

    @Test
    public void Should_makeShallowCopy() {
        //Given
        Library shallowCopiedLibrary = null;

        try {
            shallowCopiedLibrary = originalLibrary.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //When
        shallowCopiedLibrary.getBooks().add(new Book("t", "a", LocalDate.now()));
        //Then
        Assert.assertEquals(shallowCopiedLibrary.getBooks(), originalLibrary.getBooks());
    }

    @Test
    public void Should_makeDeepCopy() {
        //Given
        Library deepCopiedLibrary = null;

        try {
            deepCopiedLibrary = originalLibrary.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        deepCopiedLibrary.getBooks().add(new Book("t", "a", LocalDate.now()));

        //Then
        Assert.assertEquals(10, originalLibrary.getBooks().size());
        Assert.assertEquals(11, deepCopiedLibrary.getBooks().size());
    }

    @Before
    public void fillInLibrary() {
        IntStream
                .iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> originalLibrary
                        .getBooks()
                        .add(new Book("title " + n, "author " + n, LocalDate.now())));

    }
}
