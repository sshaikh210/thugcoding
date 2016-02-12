package app.repositories;

import app.models.Tutorial;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
public interface TutorialRepository extends CrudRepository<Tutorial, Long> {
    Iterable<Tutorial> getTutorialByActive(Boolean active);
    Tutorial findOneByActive(Long id,Boolean active);
}
