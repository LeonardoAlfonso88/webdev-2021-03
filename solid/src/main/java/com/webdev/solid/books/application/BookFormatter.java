package com.webdev.solid.books.application;

import com.webdev.solid.books.models.Book;
import com.webdev.solid.books.services.Formatter;

public class BookFormatter {

    private Book book;
    private Formatter formatter;

    public BookFormatter(Formatter formatter) throws Exception {
        this.book = new Book("24091ff7-dd77-4b8e-b196-e2bea9e3b8cf", "Infierno de Dante", "Lorem", 1966, 25000d, "Dante");
        this.formatter = formatter;
    }

    public String execute() {
        return this.formatter.format(this.book);
    }
}
