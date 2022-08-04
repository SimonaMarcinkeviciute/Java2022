package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.dto.Article;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ArticleRepository {

    private final Map<UUID, Article> articles;

    public ArticleRepository() {
        articles = new HashMap<>();
    }


    public void saveArticle(Article article) {
        articles.put(article.getId(), article);

    }

    public List<Article> getArticles() {
        return articles.values()
                .stream()
                .toList();
    }

    public Article getArticle(UUID id) {
        return articles.get(id);
    }

    public void delete(UUID id) {
        articles.remove(id);
    }
}

