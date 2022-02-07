package springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import springmvc.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
