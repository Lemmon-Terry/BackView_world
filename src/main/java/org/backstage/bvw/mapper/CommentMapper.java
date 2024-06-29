package org.backstage.bvw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.backstage.bvw.domain.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    public void addComment(Comment comment);

    public List<Comment> selectCommentByBookId(int bookId);

    public void deleteCommentById(int id);

    public Comment selectCommentById(int id);
}
