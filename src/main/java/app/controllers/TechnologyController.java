package app.controllers;

import app.models.Technology;
import app.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author abdul.jabbar@octryx.com 2/10/2016.
 */
@RestController
@RequestMapping("/api/technology")
public class TechnologyController extends CrudController<Technology,TechnologyService> {
    @Autowired
    @Override
    public void setService(TechnologyService service) {
        this.service = service;
    }
    @Override
    public Boolean isAuthorized(Long entityId, TechnologyService service) {
        return service.isAuthorized(entityId,service);
    }
}
