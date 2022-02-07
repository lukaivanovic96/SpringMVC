package springmvc.services.mapservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.DomainObject;
import springmvc.domain.Product;
import springmvc.services.ProductService;

import java.util.List;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractDomainObjectService implements ProductService {

    @Override
    public List<DomainObject> all() {
        return super.all();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return (Product) super.saveOrUpdate(product);
    }


    @Override
    public void delete(Integer id) {
        domainObjects.remove(id);
    }
}
