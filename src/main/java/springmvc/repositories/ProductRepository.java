package springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import springmvc.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
