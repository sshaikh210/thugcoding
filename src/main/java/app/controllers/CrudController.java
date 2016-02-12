package app.controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import app.models.Model;
import app.services.CrudService;

@RestController
public abstract class CrudController<M extends Model, S extends CrudService<M, ? extends CrudRepository<M,Long>>> {
    S service;
    
    public abstract void setService(S service);
    public abstract Boolean isAuthorized(Long entityId, S service);
    @RequestMapping(method = RequestMethod.POST)
    public  @ResponseBody M create(@RequestBody M object) {
        if(isAuthorized(object.getId(), service)) {
            return service.save(object);
        }
        logUnauthorizedAccess();
        return null;
    }
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public  @ResponseBody M update(@PathVariable("id") long id, @RequestBody M object) {
        if(isAuthorized(object.getId(), service)) {
            return service.update(id,object);
        }
        logUnauthorizedAccess();
        return null;
    }
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean delete(@PathVariable("id") long id) {
        if(isAuthorized(id, service)) {
            return service.delete(id);
        }
        logUnauthorizedAccess();
        return null;
    }
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody M get(@PathVariable("id") long id) {
        return service.get(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<M> getAll(ModelMap map) {
        return service.getAll();
    }
    
    private void logUnauthorizedAccess() {
        System.out.println("!!UN-AUTHORIZED ACCESS DETECTED!!");
    }
}
