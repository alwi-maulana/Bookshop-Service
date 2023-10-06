package id.ac.ittelkompwt.Bookshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.ac.ittelkompwt.Bookshop.constant.ResponseMessage;
import id.ac.ittelkompwt.Bookshop.entity.Book;
import id.ac.ittelkompwt.Bookshop.entity.Member;
import id.ac.ittelkompwt.Bookshop.entity.Purchase;
import id.ac.ittelkompwt.Bookshop.entity.PurchaseDetail;
import id.ac.ittelkompwt.Bookshop.exception.DataNotFoundException;
import id.ac.ittelkompwt.Bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    MemberService memberService;

    @Autowired
    BookService bookService;

    @Override
    public Purchase transaction(Purchase purchase) throws JsonProcessingException {

//        DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
//        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        Purchase purchase1 = purchaseRepository.save(purchase);
        Member member = memberService.getMemberById(purchase.getMember().getMemberId());
//        purchase1.setPurchaseDate(dateTimeRegistrar);

        purchase1.setMember(member);

        for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
            Book book =  bookService.getBookById(purchaseDetail.getBook().getBookId());
            purchaseDetail.setPurchase(purchase1);

            if (book.getStock() == 0) {
                throw new DataNotFoundException("Book is out of stock");
            }
            if (book.getStock() < purchaseDetail.getQuantity()) {
                String message = String.format(ResponseMessage.BAD_REQUEST, book.getBookId(), book.getTitle() );
                throw new DataNotFoundException(message);
            }
            book.setStock(book.getStock() - purchaseDetail.getQuantity());
            bookService.updateBook(book);
            purchaseDetail.setPriceSell((double) (book.getPrice() * purchaseDetail.getQuantity()));
            purchaseDetail.setBook(book);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);
        }
        return purchase1;
    }

    @Override
    public Purchase getPurchaseById(String purchaseId) {
        return purchaseRepository.findById(purchaseId).get();
    }
}
