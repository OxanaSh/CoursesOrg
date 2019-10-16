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

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                new Student(new Person("Basil", "Ivanov", "Ivanov", LocalDate.now(), "098766631"), "basil", "basil@gmail.com"),
                new Student(new Person("Peter", "Ivanov", "Ivanov", LocalDate.now(), "098766631"), "basil", "basil@gmail.com"),
                new Student(new Person("Vasya", "Ivanov", "Ivanov", LocalDate.now(), "098766631"), "basil", "basil@gmail.com")
    ));


    @Autowired
    StudentRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(students);
    }



    @Override
    public List<Student> getAll() {
        return repository.findAll();
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
