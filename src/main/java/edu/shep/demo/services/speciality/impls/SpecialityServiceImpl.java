package edu.shep.demo.services.speciality.impls;

import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Subject;
import edu.shep.demo.repository.SpecialityRepository;
import edu.shep.demo.services.speciality.interfaces.ISpecialityService;
import edu.shep.demo.services.subject.impls.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialityServiceImpl implements ISpecialityService {
    @Autowired
    SpecialityRepository repository;

    List <Speciality> specialities = new ArrayList<>(
            Arrays.asList(
                    new Speciality(141, "English teacher", 22, null),
                    new Speciality(143, "Programmer", 20, null),
                    new Speciality(144, "Math teacher", 15, null)
            )
    );


    @PostConstruct
    void init(){
        //repository.deleteAll();
      //  repository.saveAll(specialities);
    }



    @Override
    public List<Speciality> getAll() {
        return repository.findAll();
    }

    @Override
    public Speciality get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Speciality create(Speciality speciality) {
        return repository.save(speciality);
    }

    @Override
    public Speciality update(Speciality speciality) {
        return repository.save(speciality);
    }

    @Override
    public Speciality delete(String id) {
        Speciality speciality = this.get(id);
        repository.deleteById(id);
        return speciality;
    }
}
