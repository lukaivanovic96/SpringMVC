package springmvc.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.Product;
import springmvc.repositories.ProductRepository;
import springmvc.services.ProductService;

import java.util.List;

@Service
@Profile("repository")
public class ProductServiceRepImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> all() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
