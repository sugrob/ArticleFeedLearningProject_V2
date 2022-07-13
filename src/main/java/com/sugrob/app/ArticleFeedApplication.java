package com.sugrob.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sugrob.app.*")
//@EnableJpaRepositories(basePackages = "com.sugrob.app")
//@EntityScan(basePackages = "com.sugrob.app.entity")
public class ArticleFeedApplication
//        extends SpringBootServletInitializer
{

    public static void main(String[] args) {
        SpringApplication.run(ArticleFeedApplication.class, args);
    }
}