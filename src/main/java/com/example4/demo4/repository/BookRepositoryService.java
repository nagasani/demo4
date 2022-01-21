package com.example4.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example4.demo4.model.Book;

@Repository
public interface BookRepositoryService extends JpaRepository<Book, Integer> {

}
