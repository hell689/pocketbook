package com.example.pocketbook.domain.Document;

import javax.persistence.*;
import java.util.List;

@Entity
public class ChangeBalanceTablePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "changeBalanceTablePart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChangeBalanceTableRow> rows;

    @OneToOne
    private ChangeBalanceDocument changeBalanceDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChangeBalanceTableRow> getRows() {
        return rows;
    }

    public void setRows(List<ChangeBalanceTableRow> rows) {
        this.rows = rows;
    }

    public ChangeBalanceDocument getChangeBalanceDocument() {
        return changeBalanceDocument;
    }

    public void setChangeBalanceDocument(ChangeBalanceDocument changeBalanceDocument) {
        this.changeBalanceDocument = changeBalanceDocument;
    }
}
