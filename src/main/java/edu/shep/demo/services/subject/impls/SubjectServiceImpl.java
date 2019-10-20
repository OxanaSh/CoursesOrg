package edu.shep.demo.services.subject.impls;

import edu.shep.demo.model.Subject;
import edu.shep.demo.repository.SubjectRepository;
import edu.shep.demo.services.subject.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    SubjectRepository repository;

    List<Subject> subjects = new ArrayList<>(
            Arrays.asList(
                    new Subject("Math", 125),
                    new Subject("English", 10),
                    new Subject("Programming", 10),
                    new Subject("Physics", 10)
            )
    );


    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(subjects);
    }

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
