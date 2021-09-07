package com.webdev.solid.books.services;

import com.webdev.solid.books.models.Book;

public class PlainFormatter implements Formatter{
    @Override
    public String format(Book book) {
        return "El id del libro es:  " + book.getId();
    }
}
