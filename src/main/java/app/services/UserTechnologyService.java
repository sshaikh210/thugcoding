package app.services;

import app.models.User_Technology;
import app.repositories.TechnologyRepository;
import app.repositories.UserTechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@Service
public class UserTechnologyService extends CrudService<User_Technology,UserTechnologyRepository> {
    @Autowired
    @Override
    public void setRepo(UserTechnologyRepository repo) {
        this.repo = repo;
    }
    private final TechnologyRepository technologyRepository;
    private final UserService userService;
    @Autowired
    public UserTechnologyService(TechnologyRepository technologyRepository,UserService userService)
    {
        this.technologyRepository=technologyRepository;
        this.userService = userService;
    }
    @Override
    public User_Technology copy(User_Technology from, User_Technology to) {
        to = from;
        return to;
    }
    @Override
    public User_Technology save(User_Technology model) {
        model.setUser_technology(technologyRepository.findOne(model.getUser_technology().getId()));
        model.setUser(userService.getLoggedInUser());
        return this.repo.save(model);
    }
    @Override
    public Iterable<User_Technology> getAll() {
        return this.repo.getUserTechnologyByActiveAndUser(true,userService.getLoggedInUser());
    }
    @Override
    public User_Technology get(Long id) {
        return this.repo.findOneByActiveAndUser(id,true,userService.getLoggedInUser());
    }
}
