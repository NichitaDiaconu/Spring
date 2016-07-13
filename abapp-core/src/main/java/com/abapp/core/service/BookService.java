package com.abapp.core.service;

import com.abapp.core.model.Author;
import com.abapp.core.model.Book;
import com.abapp.core.repository.AuthorRepository;
import com.abapp.core.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAllBooks(){
        List<Book> books = this.bookRepository.findAll();
        Author a = new Author();
        for (Book b :books) {
            b.getAuthor().equals(a);

        }
        return this.bookRepository.findAll();
    }

    public List<Book> findAllByAuthorId(Long authorId){
        return this.bookRepository.findAllByAuthor_Id(authorId);
    }

    public Book updateBook(Long id, String title, String isbn, Long year, Long author){
        Book book = bookRepository.findOne(id);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setYear(year);
        Author author1 = this.authorRepository.findOne(author);
        book.setAuthor(author1);
        this.bookRepository.save(book);
        return book;
    }
}
