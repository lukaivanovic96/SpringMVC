package springmvc.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import springmvc.domain.Customer;
import springmvc.domain.User;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("repository")
public class CustomerServiceTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testListMethod() throws Exception {

        List<Customer> customers = (List<Customer>) customerService.all();
        assert customers.size() == 3;
    }

    @Test
    public void testGetByIdMethod() {
        Customer customer = customerService.getById(6);
        assert customer.getId() == 6;
    }

    @Test
    public void testSaveOrUpdateMethod() {
        customerService.saveOrUpdate(new Customer());
        assert customerService.all().size() == 4;
    }

    @Test
    public void testDeleteMethod() {
        customerService.delete(6);
        assert customerService.all().size() == 2;
    }

    @Test
    public void testSaveWithUser(){
        Customer customer = new Customer();
        User user = new User();
        user.setUsername("name");
        user.setPassword("pass");
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getId() != null;
    }
}
