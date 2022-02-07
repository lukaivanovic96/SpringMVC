package springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import springmvc.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
