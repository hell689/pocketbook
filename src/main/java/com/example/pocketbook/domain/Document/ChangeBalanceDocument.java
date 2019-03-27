package com.example.pocketbook.domain.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ChangeBalanceDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=9)
    private String sNumber;
    private Date date;
    @OneToOne
    private ChangeBalanceTablePart changeBalanceTablePart;
    private boolean isHolding = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ChangeBalanceTablePart getChangeBalanceTablePart() {
        return changeBalanceTablePart;
    }

    public void setChangeBalanceTablePart(ChangeBalanceTablePart changeBalanceTablePart) {
        this.changeBalanceTablePart = changeBalanceTablePart;
    }

    public boolean isHolding() {
        return isHolding;
    }

    public void setHolding(boolean holding) {
        isHolding = holding;
    }
}
