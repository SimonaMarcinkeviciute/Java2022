package lt.codeacademy.eshop.advice;

import lt.codeacademy.eshop.exception.ProductNotExistException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditor;

@ControllerAdvice
public class ProductAdvice {

    @ExceptionHandler(ProductNotExistException.class)
    public String handlingProductNotFound(ProductNotExistException exception, Model model) {
        model.addAttribute("productId", exception.getProductId());

        return "productNotFound";
    }

    @InitBinder
    public void initStringBinder(WebDataBinder webDataBinder) {
        PropertyEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, editor);
    }
}
