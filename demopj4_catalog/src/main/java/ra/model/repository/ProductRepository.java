package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ra.model.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
     List<Product> findByProductNameOrProductId(String productName, int productId);
    }