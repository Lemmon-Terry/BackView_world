package org.backstage.bvw.service;

import org.backstage.bvw.domain.Comment;
import org.backstage.bvw.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public List<Comment> selectCommentByBookId(int bookID){
        List<Comment> comments = commentMapper.selectCommentByBookId(bookID);
        return comments;
    }

    public void deleteComment(int id){
        commentMapper.deleteCommentById(id);
    }

    public Comment selectCommentById(int id){
        return commentMapper.selectCommentById(id);
    }
}
