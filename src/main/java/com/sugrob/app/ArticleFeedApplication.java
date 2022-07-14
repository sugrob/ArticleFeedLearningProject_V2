package com.sugrob.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@ComponentScan(basePackages = "com.sugrob.app.*")
public class ArticleFeedApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ArticleFeedApplication.class, args);
    }
}