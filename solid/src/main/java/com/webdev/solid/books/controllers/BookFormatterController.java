package com.webdev.solid.books.controllers;

import com.webdev.solid.books.application.BookFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookFormatterController {

    @Autowired
    private BookFormatter useCase;

    @GetMapping("/book/search/{option}")
    public String execute(@PathVariable("option") String option) throws Exception {
        return useCase.execute();
    }

    public BookFormatter getUseCase() {
        return useCase;
    }

    public void setUseCase(BookFormatter useCase) {
        this.useCase = useCase;
    }
}
