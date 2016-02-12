package app.services;

import app.models.Step;
import app.repositories.StepRepository;
import app.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@Service
public class StepService extends CrudService<Step,StepRepository> {

    @Autowired
    @Override
    public void setRepo(StepRepository repo) {
        this.repo = repo;
    }
    private final TutorialRepository tutorialRepository;
    private final UserService userService;
    @Autowired
    public StepService(TutorialRepository technologyRepository,UserService userService)
    {
        this.tutorialRepository=technologyRepository;
        this.userService=userService;
    }
    @Override
    public Step copy(Step from, Step to) {

        to = from;
        return to;
    }
    @Override
    public Step save(Step model) {
        model.setTutorial(tutorialRepository.findOne(model.getTutorial().getId()));
        return this.repo.save(model);
    }
    public Boolean isAuthorized(Long entityId, StepService service) {
        if(userService.getLoggedInUser().isAdmin())
            return true;
        return false;
    }
    @Override
    public Iterable<Step> getAll() {
        return this.repo.getStepByActive(true);
    }
    @Override
    public Step get(Long id) {
        return this.repo.findOneByActive(id,true);
    }
}
