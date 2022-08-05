package com.riigsoft.javarecord.repo;

import com.riigsoft.javarecord.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/***
 * @author Abdallah Mahmoud
 * @linkedin https://www.linkedin.com/in/abdallahmahmud/
 * */
/**Optional annotation*/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
