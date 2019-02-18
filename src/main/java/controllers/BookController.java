package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import models.Book;
import repositories.BookRepository;

@RestController
@RequestMapping("/api/bookcollection")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> bookList() {
        return bookRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Book book) {
        bookRepository.save(book);

    }

    @GetMapping("/{id}")
    public Book get(@PathVariable("id") long id) {
        return bookRepository.getOne(id);

    }
}
