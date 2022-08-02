package com.sugrob.app.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sugrob.app.entity.Article;
import com.sugrob.app.repository.ArticleRepository;
import com.sugrob.app.service.ArticleService;
import com.sugrob.app.service.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(ArticlesFeedController.class)
public class ArticlesFeedControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleServiceImpl service;

    @MockBean
    private ArticleRepository repository;

    @Mock
    Page<Article> feedPage;

    @CsvSource({
            "/feed, 1",
            "/feed/0, 1",
            "/feed/-1, 1",
    })
    @ParameterizedTest
    public void testFeed(String url, Integer expected) throws Exception {
        Article article = new Article();
        List<Article> pageContent = new ArrayList<Article>();
        pageContent.add(article);

        when(feedPage.getTotalPages()).thenReturn(1);
        when(feedPage.getContent()).thenReturn(pageContent);

        when(repository.findAll(any(Pageable.class))).thenReturn(feedPage);

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attribute("page", expected))
                .andExpect(model().attributeExists("totalPages"))
                .andExpect(model().attribute("totalPages", 1))
                .andExpect(model().attributeExists("list"))
                .andExpect(model().attribute("list", pageContent))
                .andExpect(view().name("feed"));
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(get("/create"))
                .andExpect(model().attributeExists("article"))
                .andExpect(view().name("create_form"));

        //TODO.. don't forget ..
    }

    @Test
    public void testEdit() throws Exception {
        Article article = new Article();
        when(repository.findById(1L)).thenReturn(Optional.of(article));

        mockMvc.perform(get("/edit/1"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attribute("article", Optional.of(article)))
                .andExpect(view().name("edit_form"));
    }

    @Test
    public void testEditNotFound() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/edit/1"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attribute("article", Optional.empty()))
                .andExpect(view().name("edit_form"));
    }
}
