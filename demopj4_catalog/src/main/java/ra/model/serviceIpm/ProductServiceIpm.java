package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.repository.CatalogRepository;
import ra.model.repository.ProductRepository;
import ra.model.service.ProductService;

import java.util.List;

@Service
public class ProductServiceIpm implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int productId) {
         productRepository.deleteById(productId);

    }

    @Override
    public List<Product> searchByName(String productName, int productId) {
        return productRepository.findByProductNameOrProductId(productName,productId);
    }
}
