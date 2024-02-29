package com.library.controller;

import com.library.DTO.create.CreateDTOBook;
import com.library.DTO.create.UpdateDTOBook;
import com.library.model.Book;
import com.library.serviceInterface.InterfaceBookCRUD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final InterfaceBookCRUD interfaceBookCRUD;
    @Autowired
    public BookController(InterfaceBookCRUD interfaceBookCRUD){
        this.interfaceBookCRUD = interfaceBookCRUD;
    }

    @PostMapping("/create-book")
    public ResponseEntity<?> createBook(@Valid @RequestBody CreateDTOBook data){
        var book = this.interfaceBookCRUD.createBook(data);
        if(book != null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(book);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PutMapping("/update-book")
    @Transactional
    public ResponseEntity<?> updateBookByTittle(@RequestBody UpdateDTOBook data){
        Book reference = this.interfaceBookCRUD.updateBookByTittle(data);
        if(reference != null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
    }
}
