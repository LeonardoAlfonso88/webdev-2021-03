package com.webdev.solid.books.application;

import com.webdev.solid.books.models.Book;

//Orquestadores
public class BookCreator {

    public Book book;

    public String execute(String Id, String Title, String Description, Integer Year, Double Price, String Author) throws Exception {
        //TODO: Call WebService
        book = new Book(Id, Title, Description, Year, Price, Author);
        //TODO: Save DB
        return book.getDescription();
    }
}
