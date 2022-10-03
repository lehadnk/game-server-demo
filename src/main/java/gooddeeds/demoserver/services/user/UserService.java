package gooddeeds.demoserver.services.user;

import gooddeeds.demoserver.persistence.models.User;
import gooddeeds.demoserver.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserByUsernameAndPassword(String username, String password)
    {
        return repository.findByUsernameAndPassword(username, password);
    }
}
