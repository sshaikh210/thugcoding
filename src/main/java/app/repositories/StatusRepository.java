package app.repositories;
import app.models.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
public interface StatusRepository extends CrudRepository<Status, Long> {
    Iterable<Status> getStatusByActive(Boolean active);
    Status findOneByActive(Long id,Boolean active);
}

