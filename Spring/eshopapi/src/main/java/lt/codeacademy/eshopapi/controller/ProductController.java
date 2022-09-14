//package lt.codeacademy.eshopapi.controller;
//
//import lt.codeacademy.eshopapi.ApplicationPath;
//import lt.codeacademy.eshopapi.dto.Product;
//import lt.codeacademy.eshopapi.service.ProductService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//import static lt.codeacademy.eshopapi.ApplicationPath.*;
//
//@RestController
//@RequestMapping(PRODUCTS)
//public class ProductController {
//
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Product> getProducts() {
//        return productService.getProducts();
//    }
//    //produce grazima
//    @GetMapping(value = PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Product getProduct(@PathVariable(productId) UUID id) {
//        return productService.getProduct(id);
//    }
//
//    //Get http metodu narsykle siuncia requesta defoultu, post turim uzsetinti
//    //sukurti kazkoki resursa,
//    // nurodom koki duomenu tipa priimam
//    //consume priima
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)//kai sukuriamas elementas grazina success statusa 201
//    //request body, kad requesta etejusi su tam tikrais duomenimis sumapintu su situo objektu
//    public void createProduct(@RequestBody Product product) {
//        productService.createProduct(product);
//    }
//
//    @PutMapping(value = PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.ACCEPTED)// 202 accepted
//    public  void updateProduct(@RequestBody Product product, @PathVariable(ApplicationPath.productId) UUID id) {
//        //updatinamas objektas tada kai turi Id, tai tada atnaujina, sukuriamas kai neturi
//        product.setId(id);
//        productService.updateProduct(product);
//    }
//
//    @DeleteMapping(value = PRODUCT) // nereikia consume ar produce nes nieko negrazinnasm ir nepriimam
//    @ResponseStatus(HttpStatus.NO_CONTENT) //204
//    public void deleteProduct(@PathVariable(productId) UUID id) {
//        productService.delete(id);
//    }
//
//    @GetMapping(value = SEARCH, produces =  MediaType.APPLICATION_JSON_VALUE)
//    //jei nepaduos reiksmes, grazins visus duomenis su required - false
//    public List<Product> search(@RequestParam(required = false) String query) {
//        return productService.search(query);
//    }
//
//
//}

package lt.codeacademy.eshopapi.controller;

import static lt.codeacademy.eshopapi.ApplicationPath.*;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.codeacademy.eshopapi.dto.Product;
import lt.codeacademy.eshopapi.exception.data.ExceptionResponse;
import lt.codeacademy.eshopapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(PRODUCTS)

@OpenAPIDefinition(tags = {
        @Tag(name = "Product Controller", description = "Eshop product controller")
})
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(tags = "Product Controller", summary = "Get all shop products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All products returned successfully", content = {@Content(schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "401", description = "User not authorized", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Request not found", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class))}),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Operation(tags = "Product Controller", summary = "Get product")
    @GetMapping(value = PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable(productId) UUID id) {
        return productService.getProduct(id);
    }

    @Operation(tags = "Product Controller", summary = "Create product")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @Operation(tags = "Product Controller", summary = "Update product")
    @PutMapping(value = PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product, @PathVariable(productId) UUID id) {
        product.setId(id);
        productService.updateProduct(product);
    }

    @Operation(tags = "Product Controller", summary = "Delete product")
    @DeleteMapping(value = PRODUCT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(productId) UUID id) {
        productService.delete(id);
    }

    @Operation(tags = "Product Controller", summary = "Search for products")
    @GetMapping(value = SEARCH, produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<Product> search(@RequestParam String query) {
        return productService.search(query);
    }
}
