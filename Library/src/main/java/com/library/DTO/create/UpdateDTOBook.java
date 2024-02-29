package com.library.DTO.create;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UpdateDTOBook(
        @NotBlank String tittle,
        String author,
        String ISBN,
        String editoral,
        LocalDate yearOfPublication,
        String gender,
        Integer numberOfBooks,
        Double price

) {
}
