package id.ac.ittelkompwt.Bookshop.service;

import id.ac.ittelkompwt.Bookshop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);
    public Book getBookById(String bookId);
    public List<Book> getAllBook();
    public Book updateBook(Book book);
    public void deleteBook(String bookId);
//    public Page<Book> getBookByPerPage(Pageable pageable);
    List<Book> searchBookTitle(String title);
    public List<Book> getAllOrderByYearAsc();
    public List<Book> getAllOrderByTitleAsc();
    public List<Book> getAllAsc();


}
