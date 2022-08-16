package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import lt.codeacademy.blogApplication.service.ArticleService;
import lt.codeacademy.blogApplication.service.CommentService;
import lt.codeacademy.blogApplication.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final MessageService messageService;
    private final CommentService commentService;

    public ArticleController(ArticleService articleService, MessageService messageService, CommentService commentService) {
        this.articleService = articleService;
        this.messageService = messageService;
        this.commentService = commentService;

    }

    @GetMapping("/save")
    public String openCreateArticle(Model model, String message) {
        model.addAttribute("article", new Article());
        model.addAttribute("message", messageService.getMessage(message));
        return "form/article";
    }

    @PostMapping("/save")
    public String createArticle(@Valid Article article, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "form/article";
        }
        article.setDate(LocalDate.now());




        String message = "lt.codeacademy.blogApplication.create.message.success";
        articleService.createArticle(article);

        return "redirect:/articles/save?message=" + message;
    }

    @GetMapping("/search")
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

    @GetMapping
    public String showProducts(Model model, @SortDefault(sort = {"date"}, direction = Sort.Direction.DESC, caseSensitive = false) Pageable pageable) {
        model.addAttribute("articlesByPage", articleService.getArticles(pageable));
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");

        return "mano";
    }



    @GetMapping("/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model, @SortDefault(sort = {"text"}, direction = Sort.Direction.DESC, caseSensitive = false) Pageable pageable) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", articleService.getArticle(id));
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");
        model.addAttribute("commentsss", commentService.find(article, pageable));

        return "articleDetails";
    }



    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));
        return "form/article";
    }

    @PostMapping("/{id}/update")
    public String updateArticle(@Valid Article article, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form/article";
        }
        article.setDate(LocalDate.now());
        articleService.updateArticle(article);

        return "redirect:/articles";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable UUID id) {
        articleService.delete(id);

        return "redirect:/articles";
    }


}

