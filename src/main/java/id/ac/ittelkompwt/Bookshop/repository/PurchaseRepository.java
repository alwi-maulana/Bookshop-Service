package id.ac.ittelkompwt.Bookshop.repository;

import id.ac.ittelkompwt.Bookshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
