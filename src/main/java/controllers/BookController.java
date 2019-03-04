package controllers;

import java.util.List;
import java.util.Optional;

import exception.AuthorNotFoundException;
import exception.BookIdMismatchException;
import exception.TitleNotFoundException;
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
        try {
            if (title == null) {
                throw new TitleNotFoundException("No title found!");
            }
        } catch (TitleNotFoundException t) {
            t.printStackTrace();
        }
        return bookRepository.findByTitle(title);
    }

    @GetMapping("/{author}")
    public List<Book> findByAuthor(@PathVariable String author) {
        try {
            if (author == null) {
                throw new AuthorNotFoundException("No author found!");
            }
        } catch (AuthorNotFoundException a) {
            a.printStackTrace();
        }
        return bookRepository.findByAuthor(author);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Book create(@RequestBody Book book) {
        Book saveBook = bookRepository.save(book);
        return saveBook;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        bookRepository.findOne(id);
        bookRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        try {
            if (book.getId() != id) {
                throw new BookIdMismatchException("Invalid id!");
            }
        } catch (BookIdMismatchException e) {
            e.printStackTrace();
        }
        bookRepository.findOne(id);
        return bookRepository.save(book);
    }
}
