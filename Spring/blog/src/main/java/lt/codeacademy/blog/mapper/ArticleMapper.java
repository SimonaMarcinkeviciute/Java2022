package lt.codeacademy.blog.mapper;

import lt.codeacademy.blog.dto.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ArticleMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Article(
                UUID.fromString(rs.getString("id")),
                rs.getString("title"),
                rs.getString("content"),
                rs.getString("date"),
                rs.getString("author")
        );
    }
}
