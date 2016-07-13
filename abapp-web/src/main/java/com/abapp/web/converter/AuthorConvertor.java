package com.abapp.web.converter;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.web.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AuthorConvertor {

    @Autowired
    private BookConvertor bookConvertor;

    public Author toEntity(AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return author;
    }

    public AuthorDTO toDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBooks(bookConvertor.convertModelsToIDs(author.getBooks()));
        return authorDTO;
    }

    public Set<AuthorDTO>
    toDTOList(Collection<Author> models) {
        return models.stream()
                .map(model -> toDTO(model))
                .collect(Collectors.toSet());
    }


}
