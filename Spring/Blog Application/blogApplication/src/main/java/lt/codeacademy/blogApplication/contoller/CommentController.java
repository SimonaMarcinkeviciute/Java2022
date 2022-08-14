package lt.codeacademy.blogApplication.contoller;


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
import java.util.UUID;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final MessageService messageService;
    private  final CommentService commentService;

    public CommentController(MessageService messageService, CommentService commentService) {
        this.messageService = messageService;
        this.commentService = commentService;
    }

    @GetMapping("/save")
    public String openCommentForm(Model model) {
        model.addAttribute("comment", new Comment());

        return "form/comment";
    }

    @PostMapping("/save")
    public String createComment(@Valid Comment comment, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "form/comment";
        }
        String message = "lt.codeacademy.blogApplication.create.message.success";
        commentService.createComment(comment);

        return "redirect:/comments/save?message=" + message;
    }

    @GetMapping
    public String showComments(Model model, @SortDefault(sort = {"text"}, direction = Sort.Direction.DESC, caseSensitive = false) Pageable pageable) {
        model.addAttribute("commentsByPage", commentService.getComments(pageable));


        return "comments";
    }


}
