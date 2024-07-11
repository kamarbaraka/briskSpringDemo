package com.kahindi.briskspringdemo.book_catalogue.controllers;


import com.kahindi.briskspringdemo.book_catalogue.repositories.BookEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"books"})
public class BookViewController {

    private final BookEntityRepository repository;

    @GetMapping
    public String viewBooks(Model model) {

        model.addAttribute("books", repository.findAll());

        return "books";
    }
}
