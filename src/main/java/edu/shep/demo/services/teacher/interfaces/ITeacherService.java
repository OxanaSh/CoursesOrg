package edu.shep.demo.services.teacher.interfaces;

import edu.shep.demo.model.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getAll();
    Teacher get(String id);
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher delete(String id);
}
