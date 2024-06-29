package org.backstage.bvw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.backstage.bvw.domain.BookContent;

import java.util.List;

@Mapper
public interface ConBookMapper {

    public List<BookContent> selectBookContent();
}
