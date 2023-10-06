package id.ac.ittelkompwt.Bookshop.controller;

import id.ac.ittelkompwt.Bookshop.entity.Book;
import id.ac.ittelkompwt.Bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestBody String title) {
        return bookService.searchBookTitle(title);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/getByYear")
    List<Book> getAllOrderByYearAsc() {
        return bookService.getAllOrderByYearAsc();
    }

    @GetMapping("/getByTitle")
    List<Book> getAllOrderByTitleAsc() {
        return bookService.getAllOrderByTitleAsc();
    }

    @GetMapping("/getAll")
    List<Book> getAllAsc() {
        return bookService.getAllAsc();
    }
}
