package org.backstage.bvw.controller;

import lombok.AllArgsConstructor;
import org.backstage.bvw.domain.Book;
import org.backstage.bvw.service.BookService;
import org.backstage.bvw.service.UserService;
import org.backstage.bvw.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MainBody")
@ResponseBody
public class IndexController {

    @Autowired
    private BookService bookService;


    @GetMapping("/bookList")
    public Result bookList(){
        String author = "张嘉佳";

        List<Book> bookList = bookService.getBooksByAuthor(author);
        if(bookList != null){
            return new Result("200","获取图书列表",bookList);
        }else {
            return new Result("404","无内容");
        }


    }
}
