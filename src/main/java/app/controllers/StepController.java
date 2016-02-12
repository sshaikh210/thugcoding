package app.controllers;

import app.models.Step;
import app.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@RestController
@RequestMapping("/api/step")
public class StepController extends CrudController<Step,StepService> {
    @Autowired
    @Override
    public void setService(StepService service) {
        this.service = service;
    }

    @Override
    public Boolean isAuthorized(Long entityId, StepService service) {
        return service.isAuthorized(entityId,service);
    }
}
