package com.library.serviceImplemtation;

import com.library.DTO.create.CreateDTOBook;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.serviceInterface.InterfaceBookCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements InterfaceBookCRUD {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(CreateDTOBook book) {
        var consultBook = findBookForTitte(book.tittle());
        if( consultBook != null){
            return this.bookRepository.save(new Book(book));
        }
        return consultBook;
    }

    @Override
    public Boolean deleteBookByTittle(String tittle) {
        return null;
    }

    @Override
    public Book updateBookByTittle(CreateDTOBook book) {
        return null;
    }

    @Override
    public Book findBookForTitte(String tittle) {
        return this.bookRepository.getReferenceByTittle(tittle);
    }
}
