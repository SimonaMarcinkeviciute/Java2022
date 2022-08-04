package lt.codeacademy.blogApplication.repository;

import lt.codeacademy.blogApplication.dto.Article;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Repository
public class ArticleRepository {

    private final Map<UUID, Article> articles;
    private final DataSource dataSource;

    public ArticleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
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

    public List<Article> getDataSourceProducts() {
        List<Article> articles = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ARTICLES");
            while(resultSet.next()) {
                articles.add(new Article(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("author"),
                        resultSet.getString("date")
                ));
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        return articles;
    }
}

