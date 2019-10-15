package edu.shep.demo.services.subject.interfaces;

import edu.shep.demo.model.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> getAll();
    Subject get(String id);
    Subject create(Subject subject);
    Subject update(Subject subject);
    Subject delete(String id);
}
