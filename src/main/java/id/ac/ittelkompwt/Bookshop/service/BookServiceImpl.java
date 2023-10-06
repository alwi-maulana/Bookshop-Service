package id.ac.ittelkompwt.Bookshop.service;

import id.ac.ittelkompwt.Bookshop.constant.ResponseMessage;
import id.ac.ittelkompwt.Bookshop.entity.Book;
import id.ac.ittelkompwt.Bookshop.exception.DataNotFoundException;
import id.ac.ittelkompwt.Bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String bookId) {
        verify(bookId);
        return bookRepository.findById(bookId).get();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        verify(book.getBookId());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String bookId) {
        verify(bookId);
        bookRepository.deleteById(bookId);
    }

//    @Override
//    public List<Book> getBookPerPage

    @Override
    public List<Book> searchBookTitle(String title) {
        return bookRepository.findBookByTitleContaining(title);
    }

    @Override
    public List<Book> getAllOrderByYearAsc() {
        return bookRepository.getAllOrderByYearAsc();
    }

    // stored procedure
    public List<Book> getAllOrderByTitleAsc() {
        return  em.createNamedStoredProcedureQuery("showAllBook").getResultList();
    }












//    @Override
//    public List<Book> getAllOrderByTitleAsc() {
//        return bookRepository.getAllOrderByTitleAsc();
//    }

    @Override
    public List<Book> getAllAsc() {
        return bookRepository.getAllAsc();
    }

    private void verify(String bookId) {
        if(!bookRepository.findById(bookId).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "customer" , bookId);
            throw new DataNotFoundException(message);
        }
    }
}
