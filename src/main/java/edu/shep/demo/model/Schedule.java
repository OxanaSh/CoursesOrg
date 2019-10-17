package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Schedule {
    @Id
    private String id;
    private StudentGroup group;
    List<Lesson> lessons;


    public Schedule() {
    }

    public Schedule(StudentGroup group, List<Lesson> lessons) {
        this.group = group;
        this.lessons = lessons;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) &&
                Objects.equals(group, schedule.group) &&
                Objects.equals(lessons, schedule.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, lessons);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", group=" + group +
                ", lessons=" + lessons +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
