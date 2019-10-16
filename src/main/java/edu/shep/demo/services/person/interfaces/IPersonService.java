package edu.shep.demo.services.person.interfaces;

import edu.shep.demo.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
    Person get(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
}
