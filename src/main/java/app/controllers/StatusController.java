package app.controllers;

import app.models.Status;
import app.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@RestController
@RequestMapping("/api/status")
public class StatusController extends CrudController<Status,StatusService> {
    @Autowired
    @Override
    public void setService(StatusService service) {
        this.service = service;
    }

    @Override
    public Boolean isAuthorized(Long entityId, StatusService service) {
        return service.isAuthorized(entityId,service);
    }
}
