package com.tistory.sylphe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        try {
            simpleDriverDataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        } catch (ClassNotFoundException e) {
            new RuntimeException(e);
        }
        simpleDriverDataSource.setPassword(password);
        simpleDriverDataSource.setUrl(url);
        simpleDriverDataSource.setUsername(username);
                /*className = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:81/ksh_test?useSSL=false&characterEncoding=utf-8";
        username = "ksh";
        password = "qwer1234";
        */
        return simpleDriverDataSource;
    }
}
