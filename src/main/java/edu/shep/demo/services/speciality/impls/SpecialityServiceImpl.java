package edu.shep.demo.services.speciality.impls;

import edu.shep.demo.model.Speciality;
import edu.shep.demo.repository.SpecialityRepository;
import edu.shep.demo.services.speciality.interfaces.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements ISpecialityService {
    @Autowired
    SpecialityRepository repository;


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
