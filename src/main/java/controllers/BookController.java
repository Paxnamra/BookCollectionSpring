package controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import models.Book;

@RestController
@RequestMapping("/api/bookcollection")
public class BookController {

    @GetMapping
    public List<Book> bookList() {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Book book) {

    }

    @GetMapping("/{id}")
    public Book get(@PathVariable("id") long id) {
        return new Book();

    }
}
