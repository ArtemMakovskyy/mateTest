package main.jdbc.databaseinfo.mate.academy.model;

import lombok.*;


import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private Long id;
    private String title;
    private BigDecimal price;
    private LiteraryFormat format;
    private List<Author> authors;

    public Book(String title, BigDecimal price, LiteraryFormat format) {
        this.title = title;
        this.price = price;
        this.format = format;
    }

    public Book(Long id, String title, BigDecimal price, LiteraryFormat format) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.format = format;
    }

    public Book(String title, BigDecimal price, LiteraryFormat format, List<Author> authors) {
        this.title = title;
        this.price = price;
        this.format = format;
        this.authors = authors;
    }
}
