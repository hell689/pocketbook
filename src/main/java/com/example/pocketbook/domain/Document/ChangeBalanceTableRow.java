package com.example.pocketbook.domain.Document;

import com.example.pocketbook.domain.Reference.ReferenceRecord;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ChangeBalanceTableRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long number;
    @OneToOne
    private ReferenceRecord referenceRecord;
    private BigDecimal sumOnBalance;
    private BigDecimal changeBalance;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "changeBalanceTablePart_id")
    private ChangeBalanceTablePart changeBalanceTablePart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public ReferenceRecord getReferenceRecord() {
        return referenceRecord;
    }

    public void setReferenceRecord(ReferenceRecord referenceRecord) {
        this.referenceRecord = referenceRecord;
    }

    public BigDecimal getSumOnBalance() {
        return sumOnBalance;
    }

    public void setSumOnBalance(BigDecimal sumOnBalance) {
        this.sumOnBalance = sumOnBalance;
    }

    public BigDecimal getChangeBalance() {
        return changeBalance;
    }

    public void setChangeBalance(BigDecimal changeBalance) {
        this.changeBalance = changeBalance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ChangeBalanceTablePart getChangeBalanceTablePart() {
        return changeBalanceTablePart;
    }

    public void setChangeBalanceTablePart(ChangeBalanceTablePart changeBalanceTablePart) {
        this.changeBalanceTablePart = changeBalanceTablePart;
    }
}
