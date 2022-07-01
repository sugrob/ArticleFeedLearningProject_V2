package com.sugrob.app.service;

import com.sugrob.app.entity.Article;
import com.sugrob.app.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void update(Article object) {
        Assert.notNull(object.getId(), "Seems object still wasn't stored");

        Optional<Article> storedObject = articleRepository.findById(object.getId());

        Assert.notNull(storedObject, "Unable to found object by id:"+object.getId());

        object.setCreatedTime(storedObject.get().getCreatedTime());

        articleRepository.save(object);
    }
}