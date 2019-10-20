package edu.shep.demo.services.student.impls;

import edu.shep.demo.model.Person;
import edu.shep.demo.model.Student;
import edu.shep.demo.repository.StudentRepository;
import edu.shep.demo.services.student.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentRepository repository;





    @PostConstruct
    void init(){
       //repository.deleteAll();
       //repository.saveAll();
    }

    //check
   // public List<Student> getAllByGroupId(){return repository.getAllByGroup_IdOrderByPersonAsc();}


    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public Student delete(String id) {
        Student student = this.get(id);
        repository.deleteById(id);
        return student;
    }
}
