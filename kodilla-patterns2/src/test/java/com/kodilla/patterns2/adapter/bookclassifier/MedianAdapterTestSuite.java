package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void Should_CalcPublicationYearMedian() throws Exception {
        //Given
        BookA bookA1 = new BookA("test1", "test1", 1, "dummy1");
        BookA bookA2 = new BookA("test1", "test1", 2, "dummy2");
        BookA bookA3 = new BookA("test1", "test1", 2, "dummy3");
        BookA bookA4 = new BookA("test1", "test1", 2, "dummy4");
        Set<BookA> bookASet = Stream.of(bookA1, bookA2, bookA3, bookA4).collect(Collectors.toSet());

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int expectedMedian = medianAdapter.publicationYearMedian(bookASet);

        //Then
        assertEquals(2, expectedMedian, 0);
    }
}
