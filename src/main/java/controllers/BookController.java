package controllers;

import java.util.List;
import java.util.Optional;

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
    public Iterable<Book> bookList() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable("id") long id) {
        return bookRepository.findOne(id);
    }

    @GetMapping("/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("/{author}")
    public List<Book> findByAuthor(@PathVariable String author) {
        return bookRepository.findByAuthor(author);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        bookRepository.findOne(id);
        bookRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        bookRepository.findOne(id);
        return bookRepository.save(book);
    }
}
