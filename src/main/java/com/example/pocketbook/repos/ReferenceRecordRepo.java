package com.example.pocketbook.repos;

import com.example.pocketbook.domain.Reference.ReferenceBook;
import com.example.pocketbook.domain.Reference.ReferenceRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReferenceRecordRepo extends CrudRepository<ReferenceRecord, Long> {

    List<ReferenceRecord> findByReferenceBook(ReferenceBook referenceBook);

}
