package com.webdev.solid.books.models;

public class Book {
    private String id;
    private String title;
    private String description;
    private Integer year;
    private Double price;
    private String author;

    public Book(String id, String title, String description, Integer year, Double price, String author) throws Exception {
        validateData(price);
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    private void validateData(Double price) throws Exception {
        if (price <= 0)
        {
            throw new Exception("Precio no valido");
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }
}
