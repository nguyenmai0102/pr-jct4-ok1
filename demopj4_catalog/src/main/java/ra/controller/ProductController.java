package ra.controller;

import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private ProductService productService;

    public ProductController() {
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAll();
    }
    @GetMapping("/{productId}")
    public Product getCatalogById(@PathVariable("productId") int productId){
        return productService.findById(productId);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }
}

