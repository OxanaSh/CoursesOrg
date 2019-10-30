package edu.shep.demo.services.student.impls;

import edu.shep.demo.model.*;
import edu.shep.demo.repository.PersonRepository;
import edu.shep.demo.repository.StudentRepository;
import edu.shep.demo.repository.UserRepository;
import edu.shep.demo.services.student.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    UserRepository userRepository;

    List<Person> persons = new ArrayList<>(
            Arrays.asList(
                   new Person("Stephan", "Ivanov", "Ivanov", LocalDate.of(2000, 11, 22), "07522334"),
                   new Person("Mark", "Ivanov", "Ivanov", LocalDate.of(1995, 7, 14), "08525934"),
                   new Person("Anastasia", "Ivanova", "Ivanovna", LocalDate.of(1998, 4, 30), "09423357")

            )
    );

    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("stephan@gmail.com", new BCryptPasswordEncoder().encode("stephan"), new ArrayList<>(Arrays.asList(Role.USER_STUDENT))),
                    new User("mark@gmail.com", new BCryptPasswordEncoder().encode("mark"), new ArrayList<>(Arrays.asList(Role.USER_STUDENT))),
                    new User("admin", new BCryptPasswordEncoder().encode("admin"), new ArrayList<>(Arrays.asList(Role.ADMIN))),
                    new User("anastasia@gmail.com", new BCryptPasswordEncoder().encode("anastasia"), new ArrayList<>(Arrays.asList(Role.USER_STUDENT)))

            )
    );


    List <Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(persons.get(0), users.get(0), true),
                    new Student(persons.get(1), users.get(1), true),
                    new Student(persons.get(2), users.get(3), true)
            )
    );



    @PostConstruct
    void init(){
      /* repository.deleteAll();
       userRepository.deleteAll();
       personRepository.deleteAll();
       personRepository.saveAll(persons);
       userRepository.saveAll(users);
       repository.saveAll(students);
       */

    }

    //check
   // public List<Student> getAllByGroupId(){return repository.getAllByGroup_IdOrderByPersonAsc();}

    public boolean existsByEnabledIsTrueAndPersonId(String personId){return  repository.existsByEnabledIsTrueAndPersonId(personId);}

    public Student findByPersonId(String id){return repository.findByPersonId(id);}

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
