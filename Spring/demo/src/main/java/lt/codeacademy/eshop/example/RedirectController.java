package lt.codeacademy.eshop.example;


import lt.codeacademy.eshop.dto.Product;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examples/redirect")
public class RedirectController {

    @GetMapping
    public String openCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "form/product";
    }

    @PostMapping
    public String saveProduct(Product product, Model model) {
        System.out.println("save product in DB");
        model.addAttribute("product", new Product());

        return "redirect:/examples/redirect";
    }

    @GetMapping("/second")
    public String secondRedirect(Product product, Model model) {
        System.out.println("second redirect");
        model.addAttribute("product", product);

        return "form/product";
    }

}
