package com.kahindi.briskspringdemo.book_catalogue.services;

import com.kahindi.briskspringdemo.book_catalogue.dtos.BookDto;
import com.kahindi.briskspringdemo.book_catalogue.entities.BookEntity;

import java.awt.print.Book;
import java.util.List;

public interface BookService {


    void publishBook(BookDto book);

    BookEntity findBookByIsbn(String isbn);

    List<BookEntity> findAllBooks();

    List<BookEntity> findBooksByAuthor(String author);
}
