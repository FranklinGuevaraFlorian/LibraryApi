package com.library.model;

import com.library.DTO.create.CreateDTOBook;
import com.library.DTO.create.UpdateDTOBook;
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
    @Column(name = "id_book")
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
    @Column(name = "year_of_publication",nullable = false)
    private LocalDate yearOfPublication;
    @Column(length = 100,nullable = false)
    private String gender;
    @Column(name = "number_of_books",nullable = false)
    private int numberOfBooks;
    @Column(nullable = false)
    private double price;

    public Book(CreateDTOBook data) {
        this.tittle = data.tittle();
        this.author = data.author();
        this.ISBN = data.ISBN();
        this.editoral = data.editoral();
        this.yearOfPublication = data.yearOfPublication();
        this.gender = data.gender();
        this.numberOfBooks = data.numberOfBooks();
        this.price = data.price();
    }

    public Book updateBook(UpdateDTOBook data){
        if(data.author() != null)
            this.author = data.author();
        if(data.ISBN() != null)
            this.ISBN = data.ISBN();
        if(data.editoral() != null)
            this.editoral = data.editoral();
        if(data.yearOfPublication() != null)
            this.yearOfPublication = data.yearOfPublication();
        if(data.gender() != null)
            this.gender = data.gender();
        if(data.numberOfBooks() != null)
            this.numberOfBooks = data.numberOfBooks();
        if(data.price() != null)
            this.price = data.price();
        return this;
    }
}
