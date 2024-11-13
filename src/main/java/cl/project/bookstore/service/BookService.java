package cl.project.bookstore.service;

import cl.project.bookstore.model.BookModel;
import cl.project.bookstore.response.ResponseModel;

import java.util.List;

public interface BookService {
    List<BookModel> getAllBooks();
    BookModel getBookById(String id);
    BookModel saveBook(BookModel book);
    BookModel updateBook(String id, BookModel book);
    ResponseModel lendBook(String id);
    ResponseModel deleteBook(String id);
}
