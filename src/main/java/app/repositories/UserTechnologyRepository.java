package app.repositories;

import app.models.User;
import app.models.User_Technology;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
public interface UserTechnologyRepository extends CrudRepository<User_Technology, Long> {
    Iterable<User_Technology> getUserTechnologyByActiveAndUser(Boolean active, User user);
    User_Technology findOneByActiveAndUser(Long id,Boolean active,User user);
}
