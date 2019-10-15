package edu.shep.demo.services.speciality.interfaces;

import edu.shep.demo.model.Speciality;

import java.util.List;

public interface ISpecialityService {
    List<Speciality> getAll();
    Speciality get(String id);
    Speciality create(Speciality speciality);
    Speciality update(Speciality speciality);
    Speciality delete(String id);
}
