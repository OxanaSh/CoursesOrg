package edu.shep.demo.services.student.impls;

import edu.shep.demo.model.Person;
import edu.shep.demo.model.Student;
import edu.shep.demo.repository.PersonRepository;
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
    @Autowired
    PersonRepository personRepository;


    List<Person> persons = new ArrayList<>(
            Arrays.asList(
                   new Person("Stephan", "Ivanov", "Ivanov", LocalDate.of(2000, 11, 22), "07522334"),
                   new Person("Mark", "Ivanov", "Ivanov", LocalDate.of(1995, 7, 14), "08525934"),
                   new Person("Anastasia", "Ivanova", "Ivanovna", LocalDate.of(1998, 4, 30), "09423357")

            )
    );


    List <Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(persons.get(0), "passs", "Stephan@gamil.com"),
                    new Student(persons.get(1), "password", "Mark@gamil.com"),
                    new Student(persons.get(2), "word", "Anastasia@gmail.com")
            )
    );



    @PostConstruct
    void init(){
       repository.deleteAll();
       personRepository.saveAll(persons);
       repository.saveAll(students);
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
