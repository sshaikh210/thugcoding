package app.controllers;

import app.models.Tutorial;
import app.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@RestController
@RequestMapping("/api/tutorial")
public class TutorialController extends CrudController<Tutorial,TutorialService> {
    @Autowired
    @Override
    public void setService(TutorialService service) {
        this.service = service;
    }
    @Override
    public Boolean isAuthorized(Long entityId, TutorialService service) {
        return service.isAuthorized(entityId,service);
    }
}
