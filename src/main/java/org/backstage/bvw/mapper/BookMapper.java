package org.backstage.bvw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.backstage.bvw.domain.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    public List<Book> selectByAuthor(String author);

    public List<Book> selectAll();
}
