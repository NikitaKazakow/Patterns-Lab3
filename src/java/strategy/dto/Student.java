package strategy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Student {

    private final String lastName;
    private final ArrayList<Subject> subjects;

    @Setter
    private double average;

    public Student(String lastName) {
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }
}
