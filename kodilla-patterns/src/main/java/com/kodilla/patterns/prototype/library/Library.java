package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public final class Library extends Prototype {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library) super.clone();

        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            Book clonedBook = new Book(
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublicationDate());

            clonedLibrary
                    .getBooks()
                    .add(clonedBook);
        }
        return clonedLibrary;
    }

}