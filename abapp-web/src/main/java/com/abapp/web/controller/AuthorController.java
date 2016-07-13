package com.abapp.web.controller;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.core.repository.AuthorRepository;
import com.abapp.core.service.AuthorService;
import com.abapp.web.MediaType;
import com.abapp.web.converter.AuthorConvertor;
import com.abapp.web.converter.BookConvertor;
import com.abapp.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class AuthorController {

    @Autowired
    private AuthorConvertor authorConverter;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookConvertor bookConvertor;

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = MediaType.API_JSON)
    public AuthorsDataDTO getAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        Set<AuthorDTO> authorDTOs = authorConverter.toDTOList(authors);
        for (AuthorDTO a :authorDTOs) {
            a.setNrBooks(this.authorService.nrBooks(a.getId()));
        }

        AuthorsDataDTO result = new AuthorsDataDTO(authorDTOs);
        return result;
    }

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAuthor(
            @PathVariable final Long authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST, consumes = MediaType.API_JSON)
    public Map<String, AuthorDTO> createStudent(
            @RequestBody final Map<String, AuthorDTO> authorDtoMap) {
        AuthorDTO authorDto = authorDtoMap.get("author");
        Author author = authorService.createAuthor(authorDto.getName());
        Map<String, AuthorDTO> result = new HashMap<>();
        result.put("author", authorConverter.toDTO(author));

        return result;
    }

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.GET, produces = MediaType.API_JSON)
    public BooksDataDTO getAuthorBooks(
            @PathVariable final Long authorId) {
        List<Book> books = authorService.getAuthorBooks(authorId);
        Set<BookDTO> bookDTOs = bookConvertor.toDTOList(books);
        BooksDataDTO result = new BooksDataDTO(bookDTOs);
        return result;
    }

}
