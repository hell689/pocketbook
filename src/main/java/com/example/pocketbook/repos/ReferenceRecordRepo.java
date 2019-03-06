package com.example.pocketbook.repos;

import com.example.pocketbook.domain.ReferenceBook;
import com.example.pocketbook.domain.ReferenceRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReferenceRecordRepo extends CrudRepository<ReferenceRecord, Long> {

    List<ReferenceRecord> findByReferenceBook(ReferenceBook referenceBook);

}
