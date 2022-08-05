package com.riigsoft.javarecord.service;

import com.riigsoft.javarecord.dto.ProductDto;
import com.riigsoft.javarecord.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    ProductDto deleteProduct(Long id);

    List<ProductDto> getAllProducts();

    Optional<ProductDto> getProduct(Long id);
}
