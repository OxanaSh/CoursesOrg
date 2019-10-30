package edu.shep.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document
public class Lesson {
    @Id
    private String id;
    private boolean wasHeld;
    private LocalDate date;
    private Map<Student, Boolean> students;
    private Subject subject;
    private boolean enabled;


    public Lesson() {
    }

    public Lesson(String id, boolean wasHeld, LocalDate date, Map<Student, Boolean> students, Subject subject, boolean enabled) {
        this.id = id;
        this.wasHeld = wasHeld;
        this.date = date;
        this.students = students;
        this.subject = subject;
        this.enabled = enabled;
    }

    public Lesson(boolean wasHeld, LocalDate date, Map<Student, Boolean> students, Subject subject) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.students = students;
        this.subject = subject;
        this.enabled = true;
    }

    public Lesson(boolean wasHeld, LocalDate date, Map<Student, Boolean> students, Subject subject, boolean enabled) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.students = students;
        this.subject = subject;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Map<Student, Boolean> getStudents() {
        return students;
    }

    public void setStudents(Map<Student, Boolean> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", wasHeld=" + wasHeld +
                ", date=" + date +
                ", students=" + students +
                ", subject=" + subject +
                ", enabled=" + enabled +
                '}';
    }
}
