package springmvc.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.domain.Order;
import springmvc.domain.Order;
import springmvc.repositories.OrderRepository;
import springmvc.services.OrderService;

import java.util.List;

@Service
public class OrderServiceRepImpl implements OrderService {

    OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> all() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }

    public Order saveOrUpdate(Order product) {
        return orderRepository.save(product);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

}
