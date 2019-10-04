package app.bootproj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    DataSource getDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/project2?serverTimezone=UTC")
                .username("root")
                .password("")
                // .create(this.dataSourceProperties.getClassLoader())
                // .url(this.dataSourceProperties.getUrl())
                // .username(this.dataSourceProperties.getUsername())
                // .password(this.dataSourceProperties.getPassword())
                .build();
        return dataSource;
    }


}
