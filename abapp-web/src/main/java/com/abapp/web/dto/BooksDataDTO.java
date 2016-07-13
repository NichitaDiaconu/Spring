package com.abapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

public class BooksDataDTO implements Serializable{

    private Set<BookDTO> books;

    public BooksDataDTO() {
    }

    public BooksDataDTO(Set<BookDTO> books) {
        this.books = books;
    }

    public Set<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDTO> books) {
        this.books = books;
    }
}
