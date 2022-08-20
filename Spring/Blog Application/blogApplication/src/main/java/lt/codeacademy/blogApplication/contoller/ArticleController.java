package lt.codeacademy.blogApplication.contoller;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import lt.codeacademy.blogApplication.service.ArticleService;
import lt.codeacademy.blogApplication.service.CommentService;
import lt.codeacademy.blogApplication.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final MessageService messageService;
    private final CommentService commentService;

    public ArticleController(ArticleService articleService, MessageService messageService, CommentService commentService) {
        this.articleService = articleService;
        this.messageService = messageService;
        this.commentService = commentService;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/articles/save")
    public String openCreateArticle(Model model, String message, ModelAndView modelAndView) {
        model.addAttribute("article", new Article());
        model.addAttribute("message", messageService.getMessage(message));
        modelAndView.addObject("action", "Save");

        return "form/article";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/articles/save")
    public String createArticle(@Valid Article article, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "form/article";
        }
        article.setDate(LocalDate.now());




        String message = "lt.codeacademy.blogApplication.create.message.success";
        articleService.createArticle(article);

        return "redirect:/articles/save?message=" + message;
    }

    @GetMapping("/public/articles/search")
    public String search(Model model,
                         @RequestParam(required = false) String title,
                         @RequestParam(required = false) String date) {

        if(title != null && !title.isBlank()) {
            if(date != null && !date.isBlank()) {
                model.addAttribute("articles", articleService.getArticlesByTitleAndDate(title, date));
            } else {
                model.addAttribute("articles", articleService.getArticlesByTitle(title));
            }
        }

        return "articles";
    }

    @GetMapping("/public/articles")
    public String showProducts(Model model, @SortDefault(sort = {"date"}, direction = Sort.Direction.DESC, caseSensitive = false) Pageable pageable) {
        model.addAttribute("articlesByPage", articleService.getArticles(pageable));
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");

        return "mano";
    }



    @GetMapping("/public/articles/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model, @SortDefault(sort = {"text"}, direction = Sort.Direction.DESC, caseSensitive = false) Pageable pageable) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", articleService.getArticle(id));
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");
        model.addAttribute("commentsss", commentService.find(article, pageable));

        return "articleDetails";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/articles/{id}/update")
    public String showUpdateForm(@PathVariable UUID id, Model model, ModelAndView modelAndView) {
        model.addAttribute("article", articleService.getArticle(id));
        modelAndView.addObject("action", "Edit");
        return "form/article";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/articles/{id}/update")
    public String updateArticle(@Valid Article article, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form/article";
        }
        article.setDate(LocalDate.now());
        articleService.updateArticle(article);

        return "redirect:/public/articles";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/articles/{id}/delete")
    public String deleteArticle(@PathVariable UUID id) {

        articleService.delete(id);

        return "redirect:/public/articles";
    }


}

