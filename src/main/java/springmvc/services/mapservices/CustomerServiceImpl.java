package springmvc.services.mapservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.Customer;
import springmvc.domain.DomainObject;
import springmvc.services.CustomerService;
import springmvc.services.security.EncryptionService;

import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractDomainObjectService implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<DomainObject> all() {
        return super.all();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if(customer.getUser() != null && customer.getUser().getPassword() != null){
            customer.getUser().setEncryptedPassword(
                    encryptionService.encryptString(customer.getUser().getPassword()));
        }
        return (Customer) super.saveOrUpdate(customer);
    }
}
