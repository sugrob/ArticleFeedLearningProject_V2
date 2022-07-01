package com.sugrob.app.repository;

import com.sugrob.app.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    Optional<Article> findById(Long id);

    Article save(Article entity);

    void delete(Article entity);

    void deleteById(Long id);

    Page<Article> findAll(Pageable pageable);
}