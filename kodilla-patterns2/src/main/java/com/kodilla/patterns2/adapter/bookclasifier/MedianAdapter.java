package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<BookA> bookASet) {

        Map<BookSignature, BookB> transitBookMap = new HashMap<>();

        for (BookA bookA : bookASet) {
            BookB bookB = new BookB(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear());
            BookSignature bookSignature = new BookSignature(bookA.getSignature());
            transitBookMap.put(bookSignature, bookB);
        }
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(transitBookMap);
    }
}
