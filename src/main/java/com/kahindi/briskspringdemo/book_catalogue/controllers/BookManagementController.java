package com.kahindi.briskspringdemo.book_catalogue.controllers;


import com.kahindi.briskspringdemo.book_catalogue.dtos.BookDto;
import com.kahindi.briskspringdemo.book_catalogue.entities.BookEntity;
import com.kahindi.briskspringdemo.book_catalogue.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
@Tag(name = "Book Management Apis")
public class BookManagementController  {

    private final BookService service;

    @PostMapping
    @Operation(
                    summary = "publish a book",
                    description = "publish a book"
    )
    public ResponseEntity<Void> createBook(@RequestBody BookDto book) {

        service.publishBook(book);

        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = {"isbn"})
    @Operation(
                    summary = "book by isbn",
                    description = "book by isbn"
    )
    public ResponseEntity<BookEntity> getBookByIsbn(@RequestParam String isbn) {

        BookEntity bookEntity = service.findBookByIsbn(isbn);

        return ResponseEntity.ok().body(bookEntity);
    }

    @GetMapping
    @Operation(
                    summary = "get all books",
                    description = "get all books"
    )
    public ResponseEntity<List<BookEntity>> getAllBooks() {

        List<BookEntity> bookEntities = service.findAllBooks();
        return ResponseEntity.ok().body(bookEntities);
    }

    @GetMapping(value = {"author"})
    @Operation(
                    summary = "get books by an author",
                    description = "get all books by author"
    )
    public ResponseEntity<List<BookEntity>> getBooksByAuthor(@RequestParam String author) {

        List<BookEntity> booksByAuthor = service.findBooksByAuthor(author);
        return ResponseEntity.ok(booksByAuthor);
    }
}
