package org.backstage.bvw.controller;

import org.backstage.bvw.domain.Book;
import org.backstage.bvw.domain.BookContent;
import org.backstage.bvw.service.BookService;
import org.backstage.bvw.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BookItems")
@ResponseBody
public class BookItemController {

    @Autowired
    private BookService bookService;



    @GetMapping("/subject")
    public Result bookList(){

        List<Book> bookList = bookService.getAllBooks();
        if(bookList != null){
            return new Result("200","获取图书列表",bookList);
        }else {
            return new Result("404","无内容");
        }
    }

    @GetMapping("/contentBook/{id}")
    public Result book_content(@PathVariable("id") int BookID){
        List<BookContent> conBooks = bookService.getConBooks();
        for(BookContent conBook : conBooks){
            if(conBook.getId() == BookID){
                return new Result("200","图书获得成功",conBook);
            }
        }
        return new Result("404","查无此书");
    }

}
