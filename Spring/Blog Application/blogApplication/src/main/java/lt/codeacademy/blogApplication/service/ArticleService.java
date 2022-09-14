package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.entity.ArticleEntity;
import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import lt.codeacademy.blogApplication.repository.ArticleRepository;
import lt.codeacademy.blogApplication.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public void createArticle(Article article) {
        articleRepository.save(ArticleEntity.convert(article));
    }

    public Page<Article> getArticles(Pageable pageable) {

        return articleRepository.findAll(pageable).map(Article::convert);
    }

    public List<Article> getArticles() {

        return articleRepository.findAll().stream().map(Article::convert).toList();
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
}
