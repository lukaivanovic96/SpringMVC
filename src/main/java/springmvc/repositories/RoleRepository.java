package springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import springmvc.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
