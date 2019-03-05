package com.example.pocketbook.domain;

import javax.persistence.*;

@Entity
public class ReferenceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "refbook_id")
    private ReferenceBook referenceBook;

    public ReferenceRecord(String name, ReferenceBook referenceBook) {
        this.name = name;
        this.referenceBook = referenceBook;
    }

    public ReferenceRecord(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReferenceBook getReferenceBook() {
        return referenceBook;
    }

    public void setReferenceBook(ReferenceBook referenceBook) {
        this.referenceBook = referenceBook;
    }
}
