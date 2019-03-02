package repositories;

import models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findOne(long id);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);

    void delete(long id);


}
