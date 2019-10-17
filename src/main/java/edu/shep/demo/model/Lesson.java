package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document
public class Lesson {
    @Id
    private String id;
    private boolean wasHeld;
    private LocalDate date;
    private List<Student> presentStudents;
    private Subject subject;

    public Lesson() {
    }


    public Lesson(boolean wasHeld, LocalDate date,  List<Student> presentStudents, Subject subject) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = presentStudents;
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isWasHeld() {
        return wasHeld;
    }

    public void setWasHeld(boolean wasHeld) {
        this.wasHeld = wasHeld;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Student> getPresentStudents() {
        return presentStudents;
    }

    public void setPresentStudents(List<Student> presentStudents) {
        this.presentStudents = presentStudents;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", wasHeld=" + wasHeld +
                ", date=" + date +
                ", presentStudents=" + presentStudents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return wasHeld == lesson.wasHeld &&
                Objects.equals(id, lesson.id) &&
                Objects.equals(date, lesson.date) &&
                Objects.equals(presentStudents, lesson.presentStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wasHeld, date, presentStudents);
    }
}
