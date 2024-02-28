package com.library.model;

import com.library.DTO.create.CreateDTOBook;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idBook")
@Entity
@Table(name = "tb_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    @Column(length = 200,nullable = false)
    private String tittle;
    @Column(length = 200,nullable = false)
    private String author;
    @Column(length = 200,nullable = false, unique = true)
    private String ISBN;
    @Column(length = 200,nullable = false)
    private String editoral;
    @Column(nullable = false)
    private LocalDate yearOfPublication;
    @Column(length = 100,nullable = false)
    private String gender;
    @Column(nullable = false)
    private int numberOfBooks;
    @Column(nullable = false)
    private double price;

    public Book(CreateDTOBook book) {
        this.tittle = book.tittle();
        this.author = book.author();
        this.ISBN = book.ISBN();
        this.editoral = book.editoral();
        this.yearOfPublication = book.yearOfPublication();
        this.gender = book.gender();
        this.numberOfBooks = book.numberOfBooks();
        this.price = book.price();
    }
}
