package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return id == book.id &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(numberOfPages, book.numberOfPages) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(purchasePrice, book.purchasePrice) &&
                Objects.equals(purchaseDate, book.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, numberOfPages, isbn, purchasePrice, purchaseDate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", numberOfPages=").append(numberOfPages);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", purchaseDate=").append(purchaseDate);
        sb.append('}');
        return sb.toString();
    }
}
