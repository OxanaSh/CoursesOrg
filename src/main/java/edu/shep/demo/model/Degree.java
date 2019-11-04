package edu.shep.demo.model;

public enum Degree {
    ASSOCIATE, BACHELOR, MASTER, DOCTOR, NONE;


    public String getDegree() {
        return name();
    }
}
