package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import lombok.Value;

@Value
public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;
}
