package com.kahindi.briskspringdemo.book_catalogue.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookEntity {

    @Transient
    private final Random random = new Random();
    @Id
    @Column(nullable = false)
    private final String isbn = "isbn-" + random.nextInt(100, 1000)+ "bk";
    @Column(nullable = false)
    private String title;
    private String subtitle;
    @ElementCollection
    private final Set<String> authors = new HashSet<>();
    @Column(nullable = false)
    @Default
    private double price = 0.00;
    private final LocalDate publishedDate = LocalDate.now();
}
