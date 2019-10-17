package edu.shep.demo.services.lesson.impls;

import edu.shep.demo.model.Lesson;
import edu.shep.demo.repository.LessonRepository;
import edu.shep.demo.services.lesson.interfaces.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {
    @Autowired
    LessonRepository repository;



    @Override
    public List<Lesson> getAll() {
        return repository.findAll();
    }

    @Override
    public Lesson get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Lesson create(Lesson lesson) {
        return repository.save(lesson);
    }

    @Override
    public Lesson update(Lesson lesson) {
        return repository.save(lesson);
    }

    @Override
    public Lesson delete(String id) {
        Lesson lesson = this.get(id);
        repository.deleteById(id);
        return lesson;
    }
}
