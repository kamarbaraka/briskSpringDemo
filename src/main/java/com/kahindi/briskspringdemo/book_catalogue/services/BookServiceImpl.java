package com.kahindi.briskspringdemo.book_catalogue.services;

import com.kahindi.briskspringdemo.book_catalogue.dtos.BookDto;
import com.kahindi.briskspringdemo.book_catalogue.entities.BookEntity;
import com.kahindi.briskspringdemo.book_catalogue.repositories.BookEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookEntityRepository repository;

    @Override
    public void publishBook(BookDto book) {

        BookEntity bookEntity = BookEntity.builder()
                .title(book.title())
                .subtitle(book.subtitle())
                .price(book.price())
                .build();

        bookEntity.getAuthors().addAll(book.authors());

        repository.save(bookEntity);
    }

    @Override
    public BookEntity findBookByIsbn(String isbn) {

        return repository.findByIsbn(isbn).orElseThrow();
    }

    @Override
    public List<BookEntity> findAllBooks() {

        return repository.findAll();
    }

    @Override
    public List<BookEntity> findBooksByAuthor(String author) {

        return repository.findByAuthors(author);
    }
}
