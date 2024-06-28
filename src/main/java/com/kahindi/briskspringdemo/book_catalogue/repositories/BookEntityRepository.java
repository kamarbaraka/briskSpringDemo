package com.kahindi.briskspringdemo.book_catalogue.repositories;

import com.kahindi.briskspringdemo.book_catalogue.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, String> {

    Optional<BookEntity> findByIsbn(String isbn);
    List<BookEntity> findByAuthors(String author);
}