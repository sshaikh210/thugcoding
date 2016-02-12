package app.repositories;

import app.models.Step;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
public interface StepRepository extends CrudRepository<Step, Long> {
    Iterable<Step> getStepByActive(Boolean active);
    Step findOneByActive(Long id,Boolean active);
}
