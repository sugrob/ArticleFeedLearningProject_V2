package com.sugrob.app.service;

import com.sugrob.app.entity.Article;
import com.sugrob.app.repository.ArticleRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void update(Article article) {
        Assert.notNull(article.getId(), "Id is null. Seems object still wasn't stored");

        Article foundArticle = articleRepository.findById(article.getId()).orElseThrow(() ->
                new ObjectNotFoundException(article.getId(), "Article"));

        article.setCreatedTime(foundArticle.getCreatedTime());

        articleRepository.save(article);
    }
}