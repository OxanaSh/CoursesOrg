package edu.shep.demo.services.application.impls;

import edu.shep.demo.model.Application;
import edu.shep.demo.model.Occupation;
import edu.shep.demo.repository.ApplicationRepository;
import edu.shep.demo.services.application.interfaces.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements IApplicationService {
    @Autowired
    ApplicationRepository repository;


    public List<Application> getAllTeachers(){
        return repository.findAllByWhomWantToBe(Occupation.TEACHER);
    }

    public List<Application> getAllStudents(){
        return repository.findAllByWhomWantToBe(Occupation.STUDENT);
    }


    @Override
    public List<Application> getAll() {
        return repository.findAll();
    }

    @Override
    public Application get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Application create(Application application) {
        return repository.save(application);
    }

    @Override
    public Application update(Application application) {
        return repository.save(application);
    }

    @Override
    public Application delete(String id) {
        Application application = this.get(id);
        repository.deleteById(id);
        return application;
    }
}
