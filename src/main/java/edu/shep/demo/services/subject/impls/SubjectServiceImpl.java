package edu.shep.demo.services.subject.impls;

import edu.shep.demo.model.Subject;
import edu.shep.demo.repository.SubjectRepository;
import edu.shep.demo.services.subject.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectRepository repository;

    @Override
    public List<Subject> getAll() {
        return repository.findAll();
    }

    @Override
    public Subject get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Subject create(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public Subject delete(String id) {
        Subject subject = this.get(id);
        repository.deleteById(id);
        return subject;
    }
}
