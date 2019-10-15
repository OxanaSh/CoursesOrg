package edu.shep.demo.services.student.impls;

import edu.shep.demo.model.Student;
import edu.shep.demo.services.student.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student get(String id) {
        return null;
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student delete(String id) {
        return null;
    }
}
