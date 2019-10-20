package edu.shep.demo.services.person.impls;

import edu.shep.demo.model.Person;
import edu.shep.demo.repository.PersonRepository;
import edu.shep.demo.services.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    PersonRepository repository;

    List<Person> persons = new ArrayList<>(
            Arrays.asList(
                    new Person("Basil", "Ivanov", "Ivanov", LocalDate.of(2000, 11, 22), "07522334"),
                    new Person("Lilya", "Ivanov", "Ivanov", LocalDate.of(1995, 7, 14), "08525934"),
                    new Person("Anna", "Ivanova", "Ivanovna", LocalDate.of(1998, 4, 30), "09423357"),
                    new Person("Danil", "Ivanov", "Ivanov", LocalDate.of(2002, 6, 12), "06822374"),
                    new Person("Pete", "Ivanov", "Stepanov", LocalDate.of(1990, 1, 2), "09567834")

            )
    );

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(persons);
        System.out.println("postconstruct started");
    }



    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Person create(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        return repository.save(person);
    }

    @Override
    public Person delete(String id) {
        Person person = this.get(id);
        repository.deleteById(id);
        return person;
    }
}
