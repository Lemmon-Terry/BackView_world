package org.backstage.bvw.service;

import org.backstage.bvw.domain.Book;
import org.backstage.bvw.domain.BookContent;
import org.backstage.bvw.domain.Comment;
import org.backstage.bvw.mapper.BookMapper;
import org.backstage.bvw.mapper.ConBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    ConBookMapper conBookMapper;

    public List<Book> getBooksByAuthor(String author) {
        return bookMapper.selectByAuthor(author);
    }

    public List<Book> getAllBooks(){
        return bookMapper.selectAll();
    }

    public List<BookContent> getConBooks(){
        return conBookMapper.selectBookContent();
    }


}
