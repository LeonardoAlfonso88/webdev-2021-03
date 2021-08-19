package com.webdev.solid.books.controllers;

import com.webdev.solid.books.application.BookCreator;
import com.webdev.solid.books.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCreatorController {
    @PostMapping("/book/create")
    public String execute(@RequestBody BookCreateRequest request) throws Exception {
        BookCreator book = new BookCreator();
        return book.execute(request.getId(), request.getTitle(), request.getDescription(), request.getYear(),
                request.getPrice(), request.getAuthor());
    }

    static class BookCreateRequest{
        private String id;
        private String title;
        private String description;
        private Integer year;
        private Double price;
        private String author;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
