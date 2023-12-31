package id.ac.ittelkompwt.Bookshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_book")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "showAllBook",procedureName = "showAllBook")} )

public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "BOOK_ID")
    private String bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "PAGE")
    private Integer page;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "PRICE")
    private Integer price;

    public Book() {
    }

    public Book(String bookId, String title, String description, String publisher, Integer year, Integer page, String language, Integer stock, Integer price) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.year = year;
        this.page = page;
        this.language = language;
        this.stock = stock;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
