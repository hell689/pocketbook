package com.example.pocketbook.repos;

import com.example.pocketbook.domain.Reference.ReferenceBook;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceBookRepo extends CrudRepository<ReferenceBook, Long> {

    ReferenceBook findByName(String name);

}
