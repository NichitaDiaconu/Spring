package com.abapp.web.converter;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.web.dto.AuthorDTO;
import com.abapp.web.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookConvertor {

    public Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setYear(bookDTO.getYear());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        return book;
    }

    public BookDTO toDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setYear(book.getYear());
        bookDTO.setAuthor(book.getAuthor().getId());
        return bookDTO;
    }

    public Set<BookDTO> toDTOList(Collection<Book> models) {
        return models.stream()
                .map(model -> toDTO(model))
                .collect(Collectors.toSet());
    }

    public Set<Long> convertModelsToIDs(Set<Book> models) {
        return models.stream()
                .map(model -> model.getId())
                .collect(Collectors.toSet());
    }
}
