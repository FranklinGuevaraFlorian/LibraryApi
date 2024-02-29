package com.library.serviceImplemtation;

import com.library.DTO.create.CreateDTOBook;
import com.library.DTO.create.UpdateDTOBook;
import com.library.DTO.list.ListDTOBook;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.serviceInterface.InterfaceBookCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        boolean consultBook = findBookForTitte(book.tittle());
        if (consultBook){
            return null;
        }
        return this.bookRepository.save(new Book(book));
    }

    @Override
    public Boolean deleteBookByTittle(String tittle) {
        boolean referenceBook = findBookForTitte(tittle);
        if(referenceBook){//caso si es que es distinto de null
           Book book = this.bookRepository.getReferenceByTittle(tittle);
           this.bookRepository.delete(book);
           return true;
        }
        return referenceBook;
    }

    @Override
    public Book updateBookByTittle(UpdateDTOBook book) {
        boolean referenceBook = findBookForTitte(book.tittle());
        //validar si el objeto que paso es igual al guardado
        if(referenceBook){
            var bookReplace = this.bookRepository.getReferenceByTittle(book.tittle());
            bookReplace = bookReplace.updateBook(book);
            return bookReplace;
        }
        return null;
    }
    @Override
    public Page<ListDTOBook> listBooks(Pageable pageable) {
        var countElements = this.bookRepository.count();
        if(countElements != 0){
            return this.bookRepository.findAll(pageable).map(ListDTOBook::new);
        }
        return null;
    }
    @Override
    public Boolean findBookForTitte(String tittle) {
        var referenceBook = this.bookRepository.getReferenceByTittle(tittle);
        return referenceBook != null;
    }

}
