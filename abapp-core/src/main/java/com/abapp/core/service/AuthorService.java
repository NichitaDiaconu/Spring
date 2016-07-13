package com.abapp.core.service;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.core.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        List<Author> alist = this.authorRepository.findAll();
        for (Author a:alist) {
            a.getBooks().size();
            List<Book> books = new ArrayList<>(a.getBooks());
            Set<Book> bookSet = books.stream()
                    .sorted((object1, object2) -> object1.getYear().compareTo(object2.getYear()))
                    .collect(Collectors.toSet());
            a.setBooks(bookSet);
        }
        return alist;
    }

    public void deleteAuthor(Long authorId){
        this.authorRepository.delete(authorId);
    }

    public Author createAuthor(String name){
        Author author = new Author(name);
        return authorRepository.save(author);
    }

    public int nrBooks(Long authorId){
        Author author = this.authorRepository.findOne(authorId);
        return author.getBooks().size();
    }

    public List<Book> getAuthorBooks(Long authorId){
        Author author = this.authorRepository.findOne(authorId);
        List<Book> books = new ArrayList<>(author.getBooks());
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                Long i1 = o1.getYear();
                Long i2 = o2.getYear();
                return (i1 > i2 ? -1 : (i1 == i2 ? 0 : 1));
            }
        });

        return books;
    }
}
