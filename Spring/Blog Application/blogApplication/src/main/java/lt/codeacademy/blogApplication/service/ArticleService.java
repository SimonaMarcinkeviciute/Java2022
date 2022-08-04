package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void createArticle(Article article) {
        article.setId(UUID.randomUUID());
        articleRepository.saveArticle(article);

    }

    public List<Article> getArticles() {
       return articleRepository.getArticles();

    }

    public Article getArticle(UUID id) {
        return articleRepository.getArticle(id);
    }

    public void updateArticle(Article article) {
        articleRepository.saveArticle(article);
    }

    public void delete(UUID id) {
        articleRepository.delete(id);
    }
}
