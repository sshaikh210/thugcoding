package app.controllers;

import app.models.User_Technology;
import app.services.UserTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@RestController
@RequestMapping("/api/registertechnology")
public class UserTechnologyController extends CrudController<User_Technology,UserTechnologyService> {
    @Autowired
    @Override
    public void setService(UserTechnologyService service) {
        this.service = service;
    }

    @Override
    public Boolean isAuthorized(Long entityId, UserTechnologyService service) {
        return true;
    }
}
