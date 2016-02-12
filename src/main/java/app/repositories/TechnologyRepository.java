package app.repositories;

import app.models.Technology;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
public interface TechnologyRepository extends CrudRepository<Technology, Long> {
    Iterable<Technology> getTechnologiesByActive(Boolean active);
    Technology findOneByActive(Long id,Boolean active);
}
