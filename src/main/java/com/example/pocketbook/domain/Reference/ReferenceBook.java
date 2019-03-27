package com.example.pocketbook.domain.Reference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ReferenceBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "referenceBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReferenceRecord> referenceRecords;

    public ReferenceBook() {
    }

    public ReferenceBook(String name) {
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

    public List<ReferenceRecord> getReferenceRecords() {
        return referenceRecords;
    }

    public void setReferenceRecords(List<ReferenceRecord> referenceRecords) {
        this.referenceRecords = referenceRecords;
    }

}
