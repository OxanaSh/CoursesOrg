package edu.shep.demo.services.studentGroup.interfaces;

import edu.shep.demo.model.StudentGroup;

import java.util.List;

public interface IStudentGroupService {
    List<StudentGroup> getAll();
    StudentGroup get(String id);
    StudentGroup create(StudentGroup studentGroup);
    StudentGroup update(StudentGroup studentGroup);
    StudentGroup delete(String id);
}
