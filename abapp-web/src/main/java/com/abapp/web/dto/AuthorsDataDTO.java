package com.abapp.web.dto;

import java.io.Serializable;
import java.util.Set;

public class AuthorsDataDTO implements Serializable {

    private Set<AuthorDTO> authors;

    public AuthorsDataDTO() {
    }

    public AuthorsDataDTO(Set<AuthorDTO> authors) {
        this.authors = authors;
    }

    public Set<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDTO> authors) {
        this.authors = authors;
    }
}
