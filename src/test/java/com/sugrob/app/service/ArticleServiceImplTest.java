package com.sugrob.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sugrob.app.entity.Article;
import com.sugrob.app.repository.ArticleRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceImplTest {

    public static final String TEST_STAMP = "2022-07-22 19:30:00.123";

    @InjectMocks
    ArticleServiceImpl articleService;

    @Mock
    ArticleRepository articleRepository;

    @Test
    public void testUpdateNewArticle() {
        Article newArticle = new Article();
        newArticle.setTitle("Test title");
        newArticle.setContent("Test content");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            articleService.update(newArticle);
        });

        assertTrue(exception.getMessage().contains("Id is null"));
    }

    @Test
    public void testUpdateObjectNotFound() {
        Article article = new Article();
        article.setTitle("Test title");
        article.setContent("Test content");
        article.setId(1L);

        when(articleRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ObjectNotFoundException.class, () -> {
            articleService.update(article);
        });

        assertTrue(exception.getMessage().contains("No row with the given identifier exists"));
    }

    @Test
    public void testUpdateCorrectly() {
        Article article = new Article();
        article.setTitle("Test title");
        article.setContent("Test content");
        article.setId(1L);

        Article storedObject = new Article();
        storedObject.setCreatedTime(Timestamp.valueOf(TEST_STAMP));

        when(articleRepository.findById(1L))
                .thenReturn(Optional.of(storedObject));

        articleService.update(article);

        verify(articleRepository, times(1)).save(article);
    }
}