package com.sugrob.app.controller;

import com.sugrob.app.entity.Article;
import com.sugrob.app.repository.ArticleRepository;
import com.sugrob.app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ArticlesFeedController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    private static final int FEED_PAGE_LIMIT = 3;

    @RequestMapping({"/feed/{page}", "/feed"})
    public String viewFeed(@PathVariable Optional<Integer> page, Model model) {
        int currentPage = page.orElse(1);

        if (currentPage < 1) {
            currentPage = 1;
        }

        Pageable pageRequest = PageRequest.of(
                currentPage - 1,
                FEED_PAGE_LIMIT,
                Sort.by("createdTime").descending()
        );

        Page<Article> feedPage = articleRepository.findAll(pageRequest);

        model.addAttribute("page", currentPage);
        model.addAttribute("totalPages", feedPage.getTotalPages());
        model.addAttribute("FEED_PAGE_LIMIT", FEED_PAGE_LIMIT);
        model.addAttribute("list", feedPage.getContent());

        return "feed";
    }

    @RequestMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("article", new Article());
        return "create_form";
    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Optional<Article> article = articleRepository.findById(id);
        model.addAttribute("article", article);
        return "edit_form";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("article") @Valid Article article, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "create_form";
        }

        articleRepository.save(article);
        return "redirect:/feed";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("article") @Valid Article article, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "edit_form";
        }

        articleService.update(article);

        return "redirect:/feed";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        try {
            articleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("id", id);
            return "404";
        }

        return "redirect:/feed";
    }
}