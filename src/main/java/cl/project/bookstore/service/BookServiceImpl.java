package cl.project.bookstore.service;

import cl.project.bookstore.model.BookModel;
import cl.project.bookstore.response.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    private final List<BookModel> books = createDummyData();

    @Override
    public List<BookModel> getAllBooks() {
        log.info("Getting all books from collection");
        return books;
    }

    @Override
    public BookModel getBookById(String id){
        log.info("Finding book with id= {} from collection", id);
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public BookModel saveBook(BookModel book) {
        log.info("Saving book ={} to collection", book.toString());
        books.add(book);
        return books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().orElseThrow();
    }

    @Override
    public BookModel updateBook(String id, BookModel book) {
        log.info("Updating book with id= {} from collection", id);
        BookModel foundBook = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
        foundBook.setName(book.getName());
        foundBook.setAuthor(book.getAuthor());
        foundBook.setYear(book.getYear());
        foundBook.setEdition(book.getEdition());
        foundBook.setIsbn(book.getIsbn());
        foundBook.setGenre(book.getGenre());
        return foundBook;
    }

    @Override
    public ResponseModel lendBook(String id) {
        log.info("Lending book with id= {} from collection", id);
        ResponseModel response = new ResponseModel();
        BookModel foundBook = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
        if(foundBook.isLent()){
            foundBook.setLent(false);
            response.setMessage("Book with id " + id +" was returned");
        }else{
            foundBook.setLent(true);
            response.setMessage("Book with id " + id +" was lent");
        }
        response.setCode("200");
        return response;
    }

    @Override
    public ResponseModel deleteBook(String id) {
        log.info("Deleting book with id= {} from collection", id);
        ResponseModel response = new ResponseModel();
        BookModel foundBook = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
        books.remove(foundBook);
        response.setCode("200");
        response.setMessage("Book with id " + id +"was deleted successfully");
        return response;
    }


    private List<BookModel> createDummyData(){
        log.info("Creating dummy data for list, enjoy");
        List<BookModel> books = new ArrayList<>();
        BookModel book1 = new BookModel();
        book1.setId("1");
        book1.setName("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        book1.setYear("1925");
        book1.setEdition("1st");
        book1.setIsbn("9780743273565");
        book1.setGenre("Fiction");
        book1.setLent(false);
        books.add(book1);
        BookModel book2 = new BookModel();
        book2.setId("2");
        book2.setName("1984");
        book2.setAuthor("George Orwell");
        book2.setYear("1949");
        book2.setEdition("1st");
        book2.setIsbn("9780451524935");
        book2.setGenre("Dystopian");
        book2.setLent(true);
        books.add(book2);
        return books;
    }
}
