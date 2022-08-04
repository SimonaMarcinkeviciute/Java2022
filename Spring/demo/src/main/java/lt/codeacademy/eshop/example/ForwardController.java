package lt.codeacademy.eshop.example;


import lt.codeacademy.eshop.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/examples/forward")
public class ForwardController {

    @GetMapping
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "form/product";
    }

    @PostMapping
    public String createProduct(Product product) {
        System.out.println("Save product in db");

        return "forward:/examples/forward/second";
    }

    @PostMapping("/second")
    public String secondCreateProduct(Product product, Model model) {
        System.out.println("Forward from create product form");
        product.setName(product.getName() + "_test");
        model.addAttribute("product", product);

        return "redirect:/examples/forward";
    }
}
