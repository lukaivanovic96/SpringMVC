package springmvc.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.Customer;
import springmvc.repositories.CustomerRepository;
import springmvc.services.CustomerService;

import java.util.List;

@Service
@Profile("repository")
public class CustomerServiceRepImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository productRepository) {
        this.customerRepository = productRepository;
    }

    public List<Customer> all() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
