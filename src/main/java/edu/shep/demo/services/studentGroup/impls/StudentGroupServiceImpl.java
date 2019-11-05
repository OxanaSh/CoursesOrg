package edu.shep.demo.services.studentGroup.impls;

import edu.shep.demo.model.LessonForm;
import edu.shep.demo.model.Student;
import edu.shep.demo.model.StudentGroup;
import edu.shep.demo.repository.StudentGroupRepository;
import edu.shep.demo.services.studentGroup.interfaces.IStudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements IStudentGroupService {
    @Autowired
    StudentGroupRepository repository;


  //  public StudentGroup findStudentGroupByStudentId(Student student){
    //    return repository.findStudentGroupByStudentsContain(student);
  //  }

    public List<StudentGroup> findAllBySpeciality_Name(String name, LessonForm lessonForm){
        List<StudentGroup> groups = repository.findAllBySpeciality_NameAndEnabledIsTrueAndFormOfStudying(name, lessonForm);
        List<StudentGroup> finalGroup = new ArrayList<>();
        for (StudentGroup group:groups) {
            if(group.getStudents()!=null){
                if(group.getMaxStudentsNumber()>group.getStudents().size()){ finalGroup.add(group);}
            }
            else {finalGroup.add(group);}
        }
        finalGroup.sort(Comparator.comparing(StudentGroup::getGroupNumber));
        return finalGroup;
    }

    public StudentGroup findByGroupNumber(String groupNumber){
        System.out.println("!!!!!!!!!!!!"+repository.findByGroupNumber(groupNumber));
        System.out.println("!!!!!!!!!!!!"+repository.findStudentGroupByGroupNumber(groupNumber));
        return repository.findStudentGroupByGroupNumber(groupNumber);
    }

    @Override
    public List<StudentGroup> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentGroup get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentGroup create(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    @Override
    public StudentGroup update(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    @Override
    public StudentGroup delete(String id) {
        StudentGroup studentGroup = this.get(id);
        repository.deleteById(id);
        return studentGroup;
    }
}
