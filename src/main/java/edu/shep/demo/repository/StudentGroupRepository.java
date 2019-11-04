package edu.shep.demo.repository;

import edu.shep.demo.model.Student;
import edu.shep.demo.model.StudentGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepository  extends MongoRepository<StudentGroup, String> {
   // StudentGroup findStudentGroupByStudentsContain(Student student);
}
