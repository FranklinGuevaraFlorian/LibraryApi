package com.library.serviceInterface;

import com.library.DTO.create.CreateDTOBook;
import com.library.DTO.create.UpdateDTOBook;
import com.library.model.Book;

public interface InterfaceBookCRUD {
    Book createBook(CreateDTOBook book);
    Boolean deleteBookByTittle(String tittle);
    Book updateBookByTittle(UpdateDTOBook book);
    Boolean findBookForTitte(String tittle);

}
