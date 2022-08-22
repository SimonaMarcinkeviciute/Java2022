package lt.codeacademy.blogApplication.advice;

import lt.codeacademy.blogApplication.exeption.ArticleNotExistExeption;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.beans.PropertyEditor;
import java.util.Date;

@ControllerAdvice
public class ArticleAdvice {

    @ExceptionHandler(ArticleNotExistExeption.class)
    public String handlingProductNotFound(ArticleNotExistExeption exception, Model model) {
        model.addAttribute("articleId", exception.getArticleId());

        return "articleNotFound";
    }

    @InitBinder
    public void initStringBinder(WebDataBinder webDataBinder) {
        PropertyEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, editor);
    }

    @ModelAttribute("myDate")
    public Date getCurrentDate() {
        return new Date();
    }
}
