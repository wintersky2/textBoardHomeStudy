package org.example.articleController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Article {
    private int id;
    private String title;
    private String content;
    private String author;
    private String regDate;
}