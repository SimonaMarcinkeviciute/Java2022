package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import lt.codeacademy.blogApplication.service.ArticleService;
import lt.codeacademy.blogApplication.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.UUID;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final MessageService messageService;

    public ArticleController(ArticleService articleService, MessageService messageService) {
        this.articleService = articleService;
        this.messageService = messageService;
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

        String message = "lt.codeacademy.blogApplication.create.message.success";
        articleService.createArticle(article);

        return "redirect:/articles/save?message=" + message;
    }

    @GetMapping("/search")
    public String search(Model model,
                               @RequestParam(required = false) String author,
                               @RequestParam(required = false) String date) {

        if(author != null && !author.isBlank()) {
            if(date != null && !date.isBlank()) {
                model.addAttribute("articles", articleService.getArticlesByAuthorAndDate(author, date));
            } else {
                model.addAttribute("articles", articleService.getArticlesByAuthor(author));
            }
        }

        return "articles";
    }

    @GetMapping
    public String showProducts(Model model, @SortDefault(sort = {"title"}, caseSensitive = false) Pageable pageable) {
        model.addAttribute("articlesByPage", articleService.getArticles(pageable));

        return "articles";
    }

    @GetMapping("/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));

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
        articleService.updateArticle(article);

        return "redirect:/articles";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable UUID id) {
        articleService.delete(id);

        return "redirect:/articles";
    }


}

