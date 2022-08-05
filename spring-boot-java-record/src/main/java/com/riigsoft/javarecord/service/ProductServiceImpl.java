package com.riigsoft.javarecord.service;

import com.riigsoft.javarecord.dto.ProductDto;
import com.riigsoft.javarecord.model.Product;
import com.riigsoft.javarecord.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/***
 * @author Abdallah Mahmoud
 * @linkedin https://www.linkedin.com/in/abdallahmahmud/
 * */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        var product = new Product(
                productDto.id(),
                productDto.name(),
                productDto.unitPrice()
        );

        return mapToProduct(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {

        var productDb = productRepository.findById(id);
        var product = new Product(
                productDb.get().getId(),
                productDto.name(),
                productDto.unitPrice()
        );

        productRepository.save(product);

        return mapToProduct(product);
    }

    @Override
    public ProductDto deleteProduct(Long id) {
        var product = productRepository.findById(id);
        if (product.isEmpty())
            throw new IllegalStateException("Product not found");

        productRepository.deleteById(product.get().getId());

        return mapToProduct(product.get());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getProduct(Long id) {
        var product = productRepository.findById(id);
        return Optional.of(mapToProduct(product.get()));
    }

    private ProductDto mapToProduct(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getUnitPrice()
        );
    }
}
