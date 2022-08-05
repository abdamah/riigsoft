package com.riigsoft.javarecord;

import com.riigsoft.javarecord.model.Product;
import com.riigsoft.javarecord.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
/***
 * @author Abdallah Mahmoud
 * @linkedin https://www.linkedin.com/in/abdallahmahmud/
 * */
@SpringBootApplication
public class SpringBootJavaRecordApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public SpringBootJavaRecordApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJavaRecordApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var product1 = new Product(1L, "pen", new BigDecimal("100.0"));
        var product2 = new Product(2L, "mobile", new BigDecimal("50.0"));
        var product3 = new Product(3L, "book", new BigDecimal("700.0"));
        var product4 = new Product(4L, "shoes", new BigDecimal("200.0"));

        var products = new ArrayList<Product>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        productRepository.saveAll(products);
    }
}
