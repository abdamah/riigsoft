package com.riigsoft.javarecord.controller;

import com.riigsoft.javarecord.dto.ProductDto;
import com.riigsoft.javarecord.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/***
 * @author Abdallah Mahmoud
 * @linkedin https://www.linkedin.com/in/abdallahmahmud/
 * */
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){

        return productService.saveProduct(productDto);
    }
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public ProductDto deleteProductById(@PathVariable(name = "id") Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProductById(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

}
