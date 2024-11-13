package cl.project.bookstore.model;

import lombok.Data;

@Data
public class BookModel {
    private String id;
    private String name;
    private String author;
    private String year;
    private String edition;
    private String isbn;
    private String genre;
    private boolean isLent;
}
