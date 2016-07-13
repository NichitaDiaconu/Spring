package com.abapp.web.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private  String isbn;
    private Long year;
    private Long author;

}
