package ra.model.service;

import ra.model.entity.Catalog;
import ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int productId);

    Product saveOrUpdate(Product product);

    void delete(int productId);

    List<Product> searchByName(String productName, int productId);
}
