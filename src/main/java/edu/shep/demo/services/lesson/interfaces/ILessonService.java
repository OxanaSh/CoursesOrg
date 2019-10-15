package edu.shep.demo.services.lesson.interfaces;

import edu.shep.demo.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> getAll();
    Lesson get(String id);
    Lesson create(Lesson lesson);
    Lesson update(Lesson lesson);
    Lesson delete(String id);
}





