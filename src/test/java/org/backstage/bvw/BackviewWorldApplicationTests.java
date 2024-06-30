package org.backstage.bvw;

import org.backstage.bvw.domain.Book;
import org.backstage.bvw.domain.BookContent;
import org.backstage.bvw.domain.Comment;
import org.backstage.bvw.domain.User;
import org.backstage.bvw.mapper.BookMapper;
import org.backstage.bvw.mapper.UserMapper;
import org.backstage.bvw.service.BookService;
import org.backstage.bvw.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackviewWorldApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;

}
