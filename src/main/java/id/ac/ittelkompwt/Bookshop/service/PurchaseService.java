package id.ac.ittelkompwt.Bookshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.ac.ittelkompwt.Bookshop.entity.Purchase;

public interface PurchaseService {
    //for transaction method
    Purchase transaction(Purchase purchase) throws JsonProcessingException;

    public Purchase getPurchaseById(String purchaseId);

}

