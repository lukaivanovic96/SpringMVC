package springmvc.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.security.Role;
import springmvc.repositories.RoleRepository;
import springmvc.services.RoleService;

import java.util.List;

@Service
@Profile("repository")
public class RoleServiceRepImpl implements RoleService {

    RoleRepository productRepository;

    @Autowired
    public void setRoleRepository(RoleRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Role> all() {
        return (List<Role>) productRepository.findAll();
    }

    public Role getById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Role saveOrUpdate(Role product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
