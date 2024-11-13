package cl.project.bookstore.controller;

import cl.project.bookstore.model.BookModel;
import cl.project.bookstore.response.ResponseModel;
import cl.project.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController implements BookInterface{

    @Autowired
    private BookService bookService;

    @Operation(summary = "Get all books", description = "Gets all books from list")
    @ApiResponse(responseCode = "200", description = "Books gotten successfully")
    @Override
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @Operation(summary = "Get book by id", description = "Gets a specific book from the list")
    @ApiResponse(responseCode = "200", description = "Book gotten successfully")
    @Override
    public ResponseEntity<BookModel> getBookById(String id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @Operation(summary = "Save a book", description = "Saves a book into the list")
    @ApiResponse(responseCode = "200", description = "Book saved successfully")
    @Override
    public ResponseEntity<BookModel> saveBook(BookModel book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
    }

    @Operation(summary = "Update a book", description = "Updates a book by its id")
    @ApiResponse(responseCode = "200", description = "Book updated successfully")
    @Override
    public ResponseEntity<BookModel> updateBook(String id, BookModel book) {
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @Operation(summary = "Lend a book", description = "Lends a book by its id, if the book is " +
            "lent, then returns it")
    @ApiResponse(responseCode = "200", description = "Book lent or returned successfully")
    @Override
    public ResponseEntity<ResponseModel> lendBook(String id) {
        return new ResponseEntity<>(bookService.lendBook(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete book by id", description = "Deletes a specific book from the list")
    @ApiResponse(responseCode = "200", description = "Book deleted successfully")
    @Override
    public ResponseEntity<ResponseModel> deleteBook(String id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
