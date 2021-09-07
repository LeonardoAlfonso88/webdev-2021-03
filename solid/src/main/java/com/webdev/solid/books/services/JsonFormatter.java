package com.webdev.solid.books.services;

import com.webdev.solid.books.models.Book;


public class JsonFormatter implements Formatter{
    @Override
    public String format(Book book) {
        return "{ id: " + book.getId() + " }";
    }
}
