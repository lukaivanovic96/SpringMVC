package springmvc.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import springmvc.domain.Product;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("repository")
public class ProductServiceJpaTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception {

        List<Product> products = (List<Product>) productService.all();
        assert products.size() == 5;
    }

    @Test
    public void testGetByIdMethod() {
        Product product = productService.getById(2);
        assert product.getId() == 2;
    }

    @Test
    public void testSaveOrUpdateMethod() {
        productService.saveOrUpdate(new Product());
        assert productService.all().size() == 6;
    }

    @Test
    public void testDeleteMethod() {
        productService.delete(2);
        assert productService.all().size() == 4;
    }
}
