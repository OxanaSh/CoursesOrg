package edu.shep.demo.services.application.interfaces;

import edu.shep.demo.model.Application;

import java.util.List;

public interface IApplicationService {
    List<Application> getAll();
    Application get(String id);
    Application create(Application application);
    Application update(Application application);
    Application delete(String id);
}
