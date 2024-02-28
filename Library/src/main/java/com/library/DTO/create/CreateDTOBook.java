package com.library.DTO.create;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateDTOBook(
        @NotBlank String tittle,
        @NotBlank String author,
        @NotBlank String ISBN,
        @NotBlank String editoral,
        @NotBlank LocalDate yearOfPublication,
        @NotBlank String gender,
        @NotBlank int numberOfBooks,
        @NotBlank double price

) {
}
