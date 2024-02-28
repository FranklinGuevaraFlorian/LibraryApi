package com.library.serviceInterface;

import com.library.DTO.create.CreateDTOBook;
import com.library.model.Book;

public interface InterfaceBookCRUD {
    Book createBook(CreateDTOBook book);
    Boolean deleteBookByTittle(String tittle);
    Book updateBookByTittle(CreateDTOBook book);
    Book findBookForTitte(String tittle);

}
