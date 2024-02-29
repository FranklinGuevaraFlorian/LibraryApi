package com.library.serviceInterface;

import com.library.DTO.create.CreateDTOBook;
import com.library.DTO.create.UpdateDTOBook;
import com.library.DTO.list.ListDTOBook;
import com.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceBookCRUD {
    Book createBook(CreateDTOBook book);
    Boolean deleteBookByTittle(String tittle);
    Book updateBookByTittle(UpdateDTOBook book);
    Boolean findBookForTitte(String tittle);
    Page<ListDTOBook> listBooks(Pageable pageable);

}
