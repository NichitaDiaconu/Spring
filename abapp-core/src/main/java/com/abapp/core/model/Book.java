package com.abapp.core.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="book")
public class Book implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private  String isbn;
    private Long year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;
}
