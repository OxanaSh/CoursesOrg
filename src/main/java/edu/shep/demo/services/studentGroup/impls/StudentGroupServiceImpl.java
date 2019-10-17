package edu.shep.demo.services.studentGroup.impls;

import edu.shep.demo.model.StudentGroup;
import edu.shep.demo.repository.StudentGroupRepository;
import edu.shep.demo.services.studentGroup.interfaces.IStudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements IStudentGroupService {
    @Autowired
    StudentGroupRepository repository;

    @Override
    public List<StudentGroup> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentGroup get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentGroup create(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    @Override
    public StudentGroup update(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    @Override
    public StudentGroup delete(String id) {
        StudentGroup studentGroup = this.get(id);
        repository.deleteById(id);
        return studentGroup;
    }
}
