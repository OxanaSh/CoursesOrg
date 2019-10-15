package edu.shep.demo.services.student.interfaces;

import edu.shep.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student get(String id);
    Student create(Student student);
    Student update(Student student);
    Student delete(String id);
}
