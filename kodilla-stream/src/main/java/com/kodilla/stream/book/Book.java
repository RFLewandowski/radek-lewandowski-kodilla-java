package com.kodilla.stream.book;

import lombok.Value;

@Value
public final class Book {
    String author;
    String title;
    int yearOfPublication;
    String signature;
}
