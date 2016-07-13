package com.abapp.web.controller;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.core.service.BookService;
import com.abapp.web.MediaType;
import com.abapp.web.converter.BookConvertor;
import com.abapp.web.dto.AuthorDTO;
import com.abapp.web.dto.AuthorsDataDTO;
import com.abapp.web.dto.BookDTO;
import com.abapp.web.dto.BooksDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookConvertor bookConvertor;

    @RequestMapping(value = "/books/{authorId}", method = RequestMethod.GET, produces = MediaType.API_JSON)
    public BooksDataDTO getBooks(
            @PathVariable final Long authorId
    ) {
        List<Book> authors = bookService.findAllByAuthorId(authorId);
        Set<BookDTO> authorDTOs = bookConvertor.toDTOList(authors);

        BooksDataDTO result = new BooksDataDTO(authorDTOs);
        return result;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.API_JSON)
    public BooksDataDTO getAllBooks() {
        List<Book> authors = bookService.findAllBooks();
        Set<BookDTO> authorDTOs = bookConvertor.toDTOList(authors);

        BooksDataDTO result = new BooksDataDTO(authorDTOs);
        return result;
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT, consumes = MediaType.API_JSON)
    public Map<String, BookDTO> updateBook(@PathVariable final Long bookId,
                                                 @RequestBody final Map<String, BookDTO> bookDtoMap) {
        BookDTO bookDto = bookDtoMap.get("book");

        System.out.print("\n\nkkk "+bookDto.getAuthor()+"\n\n");

        Book book = bookService.updateBook(bookId, bookDto.getTitle(), bookDto.getIsbn(), bookDto.getYear(), bookDto.getAuthor());

        Map<String, BookDTO> result = new HashMap<>();
        result.put("book",bookConvertor.toDTO(book));

        return result;
    }
}

