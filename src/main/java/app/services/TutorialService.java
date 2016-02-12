package app.services;

import app.models.Technology;
import app.models.Tutorial;
import app.repositories.TechnologyRepository;
import app.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@Service
public class TutorialService  extends CrudService<Tutorial,TutorialRepository> {
    @Autowired
    @Override
    public void setRepo(TutorialRepository repo) {
        this.repo = repo;
    }
    private final TechnologyRepository technologyRepository;
    private final UserService userService;
    @Autowired
    public TutorialService(TechnologyRepository technologyRepository,UserService userService)
    {
        this.technologyRepository=technologyRepository;
        this.userService=userService;
    }
    @Override
    public Tutorial copy(Tutorial from, Tutorial to) {
        to = from;
        return to;
    }
    @Override
    public Tutorial save(Tutorial model) {
        model.setTutorial_technology(technologyRepository.findOne(model.getTutorial_technology().getId()));
        return this.repo.save(model);
    }
    public Boolean isAuthorized(Long entityId, TutorialService service) {
        if(userService.getLoggedInUser().isAdmin())
            return true;
        return false;
    }
    @Override
    public Iterable<Tutorial> getAll() {
        return this.repo.getTutorialByActive(true);
    }
    @Override
    public Tutorial get(Long id) {
        return this.repo.findOneByActive(id,true);
    }
}
