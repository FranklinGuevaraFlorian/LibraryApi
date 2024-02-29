package com.library.DTO.list;


import com.library.model.Book;

import java.time.LocalDate;

public record ListDTOBook(
        String tittle,
        String author,
        String ISBN,
        String editoral,
        LocalDate yearOfPublication,
        String gender,
        Integer numberOfBooks,
        Double price
) {
    public ListDTOBook(Book book){
        this(book.getTittle(),
                book.getAuthor(),
                book.getISBN(),
                book.getEditoral(),
                book.getYearOfPublication(),
                book.getGender(),
                book.getNumberOfBooks(),
                book.getPrice());
    }
}
