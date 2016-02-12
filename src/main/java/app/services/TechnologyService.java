package app.services;

import app.models.Technology;
import app.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@Service
public class TechnologyService extends CrudService<Technology,TechnologyRepository> {
    @Autowired
    @Override
    public void setRepo(TechnologyRepository repo) {
        this.repo = repo;
    }
    private final UserService userService;
    @Autowired
    public TechnologyService(UserService userService)
    {
        this.userService=userService;
    }
    @Override
    public Technology copy(Technology from, Technology to) {
        to = from;
        return to;
    }

    @Override
    public Technology save(Technology model) {
        return this.repo.save(model);
    }
    public Boolean isAuthorized(Long entityId, TechnologyService service) {
        if(userService.getLoggedInUser().isAdmin())
            return true;
        return false;
    }
    @Override
    public Iterable<Technology> getAll() {
        return this.repo.getTechnologiesByActive(true);
    }
    @Override
    public Technology get(Long id) {
        return this.repo.findOneByActive(id,true);
    }
}
