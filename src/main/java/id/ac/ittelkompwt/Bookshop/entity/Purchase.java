package id.ac.ittelkompwt.Bookshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trx_purchase")
public class Purchase {


    @Id
    @GeneratedValue(generator = "uuid2") //untuk generate
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name = "purchase_ID")
    private String purchaseId;

    @Column(name = "transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @ManyToOne // memberitahu bahwa relasi purchase dan member yaitu many to one
    @JoinColumn(name = "member_id")
    private Member member;

    private  Double grandTotal;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnoreProperties("purchase")
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    public Purchase() {
    }

    public Purchase(String purchaseId, Date purchaseDate, Member member, Double grandTotal, List<PurchaseDetail> purchaseDetails) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.member = member;
        this.grandTotal = grandTotal;
        this.purchaseDetails = purchaseDetails;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
