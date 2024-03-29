package lt.codeacademy.blogApplication.contoller;

import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.service.ArticleService;
import lt.codeacademy.blogApplication.service.CommentService;
import lt.codeacademy.blogApplication.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.UUID;

@Controller

public class CommentController {

    private final MessageService messageService;
    private  final CommentService commentService;

    private final ArticleService articleService;

    public CommentController(MessageService messageService, CommentService commentService, ArticleService articleService) {
        this.messageService = messageService;
        this.commentService = commentService;
        this.articleService = articleService;
    }

    @GetMapping("/comments/{id}/save")
    public String openCommentForm(Model model, String message, @PathVariable UUID id) {

        model.addAttribute("comment", new Comment());
        model.addAttribute("message", messageService.getMessage(message));
        model.addAttribute("article", articleService.getArticle(id));
        model.addAttribute("url", "https://www.houseplantjournal.com/wp-content/uploads/2020/06/logo.svg");
        model.addAttribute("fotter", "https://plnts.com/_next/image?url=https%3A%2F%2Fwebshop.plnts.com%2Fmedia%2Fwysiwyg%2Fbanners%2FHomepage_banner_PLNTS_SS22.jpg&w=1920&q=75");

        return "form/comment";
    }

    @PostMapping("comments/{id}/save")
    public String createComment(@Valid Comment comment, BindingResult bindingResult,@PathVariable UUID id, @AuthenticationPrincipal User user) {

        if(bindingResult.hasErrors()){
            return "form/comment";
        }

        String message = "lt.codeacademy.blogApplication.create.message.success";
        Article article = articleService.getArticle(id);
        comment.setArticle(article);
        comment.setDate(LocalDate.now());
        comment.setUser(user);
        commentService.createComment(comment);

        return "redirect:/public/articles/{id}?message=" + message;
    }

    @GetMapping("/comments/{id}/{idi}/delete")
    public String deleteComment(@PathVariable UUID id) {
        commentService.delete(id);

        return "redirect:/public/articles/{idi}";
    }
}
