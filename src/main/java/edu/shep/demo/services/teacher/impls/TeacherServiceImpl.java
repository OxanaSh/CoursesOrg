package edu.shep.demo.services.teacher.impls;

import edu.shep.demo.model.Teacher;
import edu.shep.demo.repository.TeacherRepository;
import edu.shep.demo.services.teacher.interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherRepository repository;


    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher delete(String id) {
        Teacher teacher = this.get(id);
        repository.deleteById(id);
        return teacher;
    }
}
