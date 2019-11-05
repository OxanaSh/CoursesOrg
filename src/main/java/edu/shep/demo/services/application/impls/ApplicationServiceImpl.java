package edu.shep.demo.services.application.impls;

import edu.shep.demo.model.Application;
import edu.shep.demo.model.Occupation;
import edu.shep.demo.model.Student;
import edu.shep.demo.repository.ApplicationRepository;
import edu.shep.demo.services.application.interfaces.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ApplicationServiceImpl implements IApplicationService {
    @Autowired
    ApplicationRepository repository;


    public List<Application> getAllTeachers(){
        List<Application> teachers = repository.findAllByWhomWantToBe(Occupation.TEACHER);
        List<Application> finalList=new ArrayList<>();
        for (Application application:teachers
        ) {
            if(!application.isApproval()&&application.isEnabled())finalList.add(application);
        }
        for (Application application:teachers
        ) {
            if(application.isApproval()&&!application.isEnabled())finalList.add(application);
        }
        for (Application application:teachers
        ) {
            if(!application.isApproval()&&!application.isEnabled())finalList.add(application);
        }
        return finalList;

    }

    public List<Application> getAllStudents(){
       List<Application> students = repository.findAllByWhomWantToBe(Occupation.STUDENT);
       List<Application> finalList=new ArrayList<>();
        for (Application application:students
             ) {
            if(!application.isApproval()&&application.isEnabled())finalList.add(application);
        }
        for (Application application:students
        ) {
            if(application.isApproval()&&!application.isEnabled())finalList.add(application);
        }
        for (Application application:students
        ) {
            if(!application.isApproval()&&!application.isEnabled())finalList.add(application);
        }
        return finalList;
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
