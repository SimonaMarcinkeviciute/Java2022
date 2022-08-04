package lt.codeacademy.blog.controller;


import lt.codeacademy.blog.dto.Article;
import lt.codeacademy.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/save")
    public String openCreateArticles(Model model) {
        model.addAttribute("article", new Article());
        return "form/article";
    }

    @PostMapping("/save")
    public String createProduct(Article article, Model model) {
//isvalyti laukus, reikia paduoti nauja objekta
        model.addAttribute("article", new Article());
        model.addAttribute("message", "Product created successfully");
        articleService.createArticle(article);

        return "form/article";
    }

    //grazuntu visus produktus
    @GetMapping
    public String showArticles(Model model) {
        model.addAttribute("articles", articleService.getArticles());

        return "articles";
    }

    //detau puslapi atvaizduoti
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
    public String updateArticle(Article article, Model model) {
        articleService.updateArticle(article);
        model.addAttribute("articles", articleService.getArticles());

        return "articles";
    }

    @GetMapping("/{id}/delete")
    public String deletoArticle(@PathVariable UUID id, Model model) {
        articleService.delete(id);
        model.addAttribute("articles", articleService.getArticles());

        return "articles";
    }


}

//jei noretumem grazinti i kita path skirtingu htpf metodu reiktu nurodyti kelia th:action july 12
