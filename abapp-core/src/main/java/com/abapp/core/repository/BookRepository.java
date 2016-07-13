package com.abapp.core.repository;

import com.abapp.core.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAllByAuthor_Id(
            Long authorId);

}
