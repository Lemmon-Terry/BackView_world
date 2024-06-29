package org.backstage.bvw.controller;


import org.backstage.bvw.domain.Comment;
import org.backstage.bvw.domain.User;
import org.backstage.bvw.service.CommentService;
import org.backstage.bvw.service.UserService;
import org.backstage.bvw.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BookComment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result addComment(@RequestBody Comment comment) {
        List<String> usernameList = userService.userNameList();
        if (usernameList.contains(comment.getUser_name()) ) {
            if(comment.getComcontent() != null){
                commentService.addComment(comment);
                return new Result("200", "评论添加成功");
            }else {
                return new Result("404","评论不可为空");
            }
        } else {
            return new Result("500", "用户尚未注册");
        }
    }

    @GetMapping("/select/{bookId}")
    public Result selectCommentById(@PathVariable("bookId") int id) {
        List<Comment> commentList = commentService.selectCommentByBookId(id);
        if (commentList != null && commentList.size() > 0) {
            return new Result("200", "评论获取成功", commentList);
        } else {
            return new Result("500", "评论获取失败");
        }
    }

    @GetMapping("delete/{id}/{username}")
    public Result deleteCommentById(@PathVariable("username") String username, @PathVariable("id") int id) {
        List<String> usernameList = userService.userNameList();
        if (usernameList.contains(username)) {
            Comment comment = commentService.selectCommentById(id);
            if (comment != null && comment.getUser_name().equals(username)) {
                commentService.deleteComment(id);
                return new Result("200", "评论删除成功");
            } else {
                return new Result("500", "评论删除失败");
            }
        } else {
            return new Result("500", "评论删除失败");
        }
    }
}
