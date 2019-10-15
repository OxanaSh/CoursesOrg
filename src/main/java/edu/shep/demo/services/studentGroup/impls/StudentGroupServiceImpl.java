package edu.shep.demo.services.studentGroup.impls;

import edu.shep.demo.model.StudentGroup;
import edu.shep.demo.services.studentGroup.interfaces.IStudentGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements IStudentGroupService {
    @Override
    public List<StudentGroup> getAll() {
        return null;
    }

    @Override
    public StudentGroup get(String id) {
        return null;
    }

    @Override
    public StudentGroup create(StudentGroup studentGroup) {
        return null;
    }

    @Override
    public StudentGroup update(StudentGroup studentGroup) {
        return null;
    }

    @Override
    public StudentGroup delete(String id) {
        return null;
    }
}
