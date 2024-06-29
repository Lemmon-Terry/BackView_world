package org.backstage.bvw.domain;

import lombok.Data;

import java.util.List;

@Data
public class BookContent {
    private int id;
    private String bookName;
    private String author;
    private String publish;
    private String pubtime;
    private String content;

}
