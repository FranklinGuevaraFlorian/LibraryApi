package com.library.DTO.create;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateDTOBook(
        @NotBlank String tittle,
        @NotBlank String author,
        @NotBlank String ISBN,
        @NotBlank String editoral,
        @NotNull LocalDate yearOfPublication,
        @NotBlank String gender,
        @NotNull Integer numberOfBooks,
        @NotNull Double price

) {
}
