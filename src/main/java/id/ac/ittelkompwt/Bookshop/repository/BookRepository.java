package id.ac.ittelkompwt.Bookshop.repository;

import id.ac.ittelkompwt.Bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(
            value = "SELECT * FROM mst_book  WHERE title = :title",
            nativeQuery=true
    )
    List<Book> findBookByTitleContaining(
            @Param("title") String title);

    @Query(
            value = "SELECT * FROM mst_book order by year asc",
            nativeQuery=true
    )
    List<Book> getAllOrderByYearAsc();

    @Query(
            value = "SELECT * FROM mst_book order by title asc",
            nativeQuery=true
    )
    List<Book> getAllAsc();

    @Procedure(
           procedureName = "showAllBook"
    )
    List<Book> getAllOrderByTitleAsc();

}
