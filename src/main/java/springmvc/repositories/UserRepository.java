package springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import springmvc.domain.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends CrudRepository<User, Integer> {
}
