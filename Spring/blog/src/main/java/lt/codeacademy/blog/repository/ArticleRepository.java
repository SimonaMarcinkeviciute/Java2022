package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.dto.Article;
import lt.codeacademy.blog.mapper.ArticleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Repository
public class ArticleRepository {

    private final Map<UUID, Article> articles;
    private final JdbcTemplate jdbcTemplate;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new JdbcTemplate();
        articles = new HashMap<>();
    }

    public void saveArticle(Article article) {
        articles.put(article.getId(), article);
    }

    public List<Article> getArticles() {
        return  jdbcTemplate.query("select * from ARTICLES", new ArticleMapper());
    }

    public Article getArticle(UUID id) {
        return articles.get(id);
    }

    public void delete(UUID id) {
        articles.remove(id);
    }


}