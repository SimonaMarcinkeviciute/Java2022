package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import lt.codeacademy.blogApplication.repository.ArticleRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void createArticle(Article article) {
        articleRepository.save(ArticleEntity.convert(article));

    }

    public Page<Article> getArticles(Pageable pageable) {
       return articleRepository.findAll(pageable).map(Article::convert);

    }

    public Article getArticle(UUID id) {
        return articleRepository.findById(id).map(Article::convert).orElseThrow(() -> new ArticleNotExistExeption(id));
    }

    public void updateArticle(Article article) {
        articleRepository.save(ArticleEntity.convert(article));
    }

    public void delete(UUID id) {
        articleRepository.deleteById(id);
    }

    public List<Article> getArticlesByAuthor(String author) {
        return articleRepository.findAllByAuthor(author).stream()
                .map(Article::convert)
                .toList();
    }

    public List<Article> getArticlesByAuthorAndDate(String author, String date) {
        return articleRepository.getArticlesByAuthorAndDate(author, date).stream()
                .map(Article::convert)
                .toList();
    }


}
