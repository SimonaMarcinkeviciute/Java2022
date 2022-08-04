package lt.codeacademy.blogApplication.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSource =  DataSourceBuilder.create();
        dataSource.url("jdbc:h2:mem:eshopDB");
        dataSource.username("sa");
        dataSource.password("");

        return dataSource.build();
    }
}
