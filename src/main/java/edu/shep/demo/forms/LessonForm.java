package edu.shep.demo.forms;

import java.util.List;

public class LessonForm {
    private String id;
    private boolean wasHeld;
    private String date;
    private List<String> presentStudents;
    private String teacher;
    private String subject;
    private String topic;
    private boolean enabled;

    public LessonForm() {
    }

    public LessonForm(String id, boolean wasHeld, String date, List<String> presentStudents, String teacher, String topic,String subject, boolean enabled) {
        this.id = id;
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = presentStudents;
        this.teacher = teacher;
        this.enabled = enabled;
        this.topic = topic;
        this.subject = subject;
    }

    public LessonForm(String id, boolean wasHeld, String date, List<String> presentStudents, String topic,String subject, String teacher) {
        this.id = id;
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = presentStudents;
        this.teacher = teacher;
        this.enabled = true;
        this.topic = topic;
        this.subject = subject;
    }

    public LessonForm(boolean wasHeld, String date, List<String> presentStudents, String subject,String teacher, String topic, boolean enabled) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = presentStudents;
        this.teacher = teacher;
        this.enabled = enabled;
        this.topic = topic;
        this.subject = subject;
    }

    public LessonForm(boolean wasHeld, String date, List<String> presentStudents, String subject,String teacher, String topic) {
        this.wasHeld = wasHeld;
        this.date = date;
        this.presentStudents = presentStudents;
        this.teacher = teacher;
        this.enabled = true;
        this.topic = topic;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getPresentStudents() {
        return presentStudents;
    }

    public void setPresentStudents(List<String> presentStudents) {
        this.presentStudents = presentStudents;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
