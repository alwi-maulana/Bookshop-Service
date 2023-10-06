package id.ac.ittelkompwt.Bookshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.ac.ittelkompwt.Bookshop.entity.Purchase;
import id.ac.ittelkompwt.Bookshop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    Purchase saveTransaction(@RequestBody Purchase purchase) throws JsonProcessingException {
        return purchaseService.transaction(purchase);
    }

    @GetMapping
    Purchase getPurchaseById(@RequestParam String purchaseId) {
        return purchaseService.getPurchaseById(purchaseId);
    }



}
