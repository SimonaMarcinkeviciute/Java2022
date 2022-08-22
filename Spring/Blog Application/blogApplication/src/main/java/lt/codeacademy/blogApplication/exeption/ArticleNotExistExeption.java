package lt.codeacademy.blogApplication.exeption;

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
