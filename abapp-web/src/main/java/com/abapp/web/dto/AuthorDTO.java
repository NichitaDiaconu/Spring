package com.abapp.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class AuthorDTO implements Serializable{
    private Long id;
    private String name;
    private int nrBooks;
    private Set<Long> books;
}
