package lt.codeacademy.blogApplication.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


public class ArticleNotExistExeption  extends RuntimeException{
    private final UUID articleId;

    public ArticleNotExistExeption(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getArticleId() {
        return articleId;
    }
}
