package springmvc.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springmvc.domain.User;
import springmvc.repositories.UserRepository;
import springmvc.services.UserService;
import springmvc.services.security.EncryptionService;

import java.util.List;

@Service
@Profile("repository")
public class UserServiceRepImpl implements UserService {
    UserRepository userRepository;
    private EncryptionService encryptionService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<User> all() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        if(user.getPassword() != null){
            user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
