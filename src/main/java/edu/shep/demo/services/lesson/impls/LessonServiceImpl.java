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
        return null;
    }

    @Override
    public Lesson get(String id) {
        return null;
    }

    @Override
    public Lesson create(Lesson lesson) {
        return null;
    }

    @Override
    public Lesson update(Lesson lesson) {
        return null;
    }

    @Override
    public Lesson delete(String id) {
        return null;
    }
}
