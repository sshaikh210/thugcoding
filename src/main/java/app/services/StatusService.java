package app.services;

import app.models.Status;
import app.repositories.StatusRepository;
import app.repositories.UserTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@Service
public class StatusService  extends CrudService<Status,StatusRepository> {

    @Autowired
    @Override
    public void setRepo(StatusRepository repo) {
        this.repo = repo;
    }
    private final UserTechnologyRepository userTechnologyRepository;
    private final UserService userService;
    @Autowired
    public StatusService(UserTechnologyRepository userTechnologyRepository,UserService userService)
    {
        this.userTechnologyRepository = userTechnologyRepository;
        this.userService=userService;
    }
    @Override
    public Status copy(Status from, Status to) {

        to= from;
        return to;
    }
    @Override
    public Status save(Status model) {
        model.setUser_technology(userTechnologyRepository.findOne(model.getUser_technology().getId()));
        return this.repo.save(model);
    }
    @Override
    public Iterable<Status> getAll() {
        if(userService.getLoggedInUser().isAdmin())
            return this.repo.getStatusByActive(true);
        return null;
    }
    public Boolean isAuthorized(Long entityId, StatusService service) {
        if(userService.getLoggedInUser().isAdmin())
            return true;
        return false;
    }
    @Override
    public Status get(Long id) {
        if(userService.getLoggedInUser().isAdmin())
            return this.repo.findOneByActive(id,true);
        return null;
    }
}
