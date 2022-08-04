package lt.codeacademy.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article {

    private UUID id;
    private String title;
    private String content;
    private String date;
    private String author;


    public Article(String title, String content, String date, String author) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }


}
