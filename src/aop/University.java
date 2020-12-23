package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        students.add(new Student("Max", 4, 8.0));
        students.add(new Student("Ivan", 2, 8.5));
        students.add(new Student("Olga", 1, 9.0));
    }

    public List<Student> getStudents() {
        System.out.println("Info from getStudents():");
        System.out.println(students);
        return students;
    }
}
