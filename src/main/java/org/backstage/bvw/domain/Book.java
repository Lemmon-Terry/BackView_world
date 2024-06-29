package org.backstage.bvw.domain;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String content;

}
