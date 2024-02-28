package com.library.controller;

import com.library.DTO.create.CreateDTOBook;
import com.library.serviceInterface.InterfaceBookCRUD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
