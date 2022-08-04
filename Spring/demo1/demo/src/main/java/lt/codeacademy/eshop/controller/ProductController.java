package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.dto.Product;
import lt.codeacademy.eshop.service.MessageService;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * /products
 * |_GET -> gausim visus produktus!!!!
 *
 * /products/save
 * |_GET -> parodo forma
 * |_POST -> sukuriame produkta
 *
 *
 * /products/{productId}
 * |_GET
 * |_PUT
 * |_DELETE
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final MessageService messageService;

    public ProductController(ProductService productService, MessageService messageService) {
        this.productService = productService;
        this.messageService = messageService;
    }

    @GetMapping("/save")
    public String openCreateProduct(Model model, String message) {
        model.addAttribute("product", new Product());
        model.addAttribute("message", messageService.getMessage(message));

        return "form/product";
    }

    @PostMapping("/save")
    public String createProduct(Product product) {

        String message = "lt.codeacademy.eshop.product.create.message.success";
        productService.createProduct(product);

        return "redirect:/products/save?message=" + message;
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(required = false) String category,
                         @RequestParam(required = false) BigDecimal price) {

        if(category != null && !category.isBlank()) {
            if(price != null && !price.equals(0)) {
                model.addAttribute("products", productService.getProductsByCategoryAndPrice(category, price));
            } else {
                model.addAttribute("products", productService.getProductsByCategory(category));
            }
        }

        return "products";
    }

    @GetMapping
    public String showProducts(Model model, @SortDefault(sort = {"name"}, caseSensitive = false) Pageable pageable) {
        model.addAttribute("productsByPage", productService.getProducts(pageable));

        return "products";
    }

    @GetMapping("/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProduct(id));

        return "productDetails";
    }

    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "form/product";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable UUID id) {
        productService.delete(id);

        return "redirect:/products";
    }
}
