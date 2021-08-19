package com.webdev.solid.books.services;

import com.webdev.solid.books.models.Book;


public class XmlFormatter implements Formatter{
    @Override
    public String format(Book book) {

        //TODO: Call Service Web Save Description Book
        return "<element><attribute>Id</attribute><value>" + book.getId() + "</value></element>";
    }

}
