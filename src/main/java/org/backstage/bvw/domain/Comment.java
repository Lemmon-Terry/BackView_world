package org.backstage.bvw.domain;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String user_name;
    private String comcontent;
    private int book_id;
}
