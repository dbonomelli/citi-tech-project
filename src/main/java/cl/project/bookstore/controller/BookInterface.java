package cl.project.bookstore.controller;

import cl.project.bookstore.model.BookModel;
import cl.project.bookstore.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/api/books")
public interface BookInterface {

    @GetMapping()
    public ResponseEntity<List<BookModel>> getAllBooks();

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(
            @PathVariable("id") String id
    );

    @PostMapping()
    public ResponseEntity<BookModel> saveBook(
            @RequestBody BookModel book
    );

    @PutMapping()
    public ResponseEntity<BookModel> updateBook(
            @PathVariable("id") String id,
            @RequestBody BookModel book
    );

    @PostMapping("/lendBook/{id}")
    public ResponseEntity<ResponseModel> lendBook(
            @PathVariable("id") String id
    );

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteBook(
            @PathVariable("id") String id
    );


}
