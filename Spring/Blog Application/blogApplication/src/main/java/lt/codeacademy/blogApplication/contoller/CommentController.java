package lt.codeacademy.blogApplication.contoller;


import lt.codeacademy.blogApplication.dto.Article;
import lt.codeacademy.blogApplication.dto.Comment;
import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.service.ArticleService;
import lt.codeacademy.blogApplication.service.CommentService;
import lt.codeacademy.blogApplication.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/public/comments/{id}/save")
    public String openCommentForm(Model model, String message) {

        model.addAttribute("comment", new Comment());
        model.addAttribute("message", messageService.getMessage(message));

        return "form/comment";
    }


    @PostMapping("/public/comments/{id}/save")
    public String createComment(@Valid Comment comment, BindingResult bindingResult,@PathVariable UUID id) {
        if(bindingResult.hasErrors()){
            return "form/comment";
        }
        String message = "lt.codeacademy.blogApplication.create.message.success";
        Article article = articleService.getArticle(id);
        comment.setArticle(article);
        comment.setDate(LocalDate.now());
        commentService.createComment(comment);

        return "redirect:/articles/{id}?message=" + message;
    }

}
