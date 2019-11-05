package edu.shep.demo.repository;

import edu.shep.demo.model.LessonForm;
import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Student;
import edu.shep.demo.model.StudentGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepository  extends MongoRepository<StudentGroup, String> {
   // StudentGroup findStudentGroupByStudentsContain(Student student);
    List<StudentGroup> findAllBySpeciality_NameAndEnabledIsTrueAndFormOfStudying(String name, LessonForm lessonForm);
    StudentGroup findByGroupNumber(String groupNumber);
    StudentGroup findStudentGroupByGroupNumber(String groupNumber);
  }
