package edu.inconcept.netflix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("edu.inconcept.netflix.repository")
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    @Value("${application.datasource.driverClassName}")
    String driverClassName;
    @Value("${application.datasource.url}")
    String url;
    @Value("${application.datasource.username}")
    String username;
    @Value("${application.datasource.password}")
    String password;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
        return dataSource;
    }
}
