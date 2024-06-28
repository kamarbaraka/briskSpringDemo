package com.kahindi.briskspringdemo.book_catalogue.dtos;

import java.io.Serializable;
import java.util.List;

public record BookDto(
        String title,
        String subtitle,
        List<String> authors,
        double price
) implements Serializable {
}
