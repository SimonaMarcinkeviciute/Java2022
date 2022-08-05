package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.service.ArticleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/save")
    public String openCreateArticle(Model model, String message) {
        model.addAttribute("article", new Article());
        model.addAttribute("message", message);
        return "form/article";
    }

    @PostMapping("/save")
    public String createProduct(Article article) {
        String message = "Article created succesfully";
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
    public String updateArticle(Article article) {
        articleService.updateArticle(article);

        return "redirect:/articles";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable UUID id) {
        articleService.delete(id);

        return "redirect:/articles";
    }
}

