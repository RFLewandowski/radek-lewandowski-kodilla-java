package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import lombok.Value;

@Value
public class Book {
    private final String author;
    private final String title;
    private final int yearOfPublication;
}
