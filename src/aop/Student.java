package aop;

public class Student {
    private String name;
    private int course;
    private double averageMark;

    public Student(String name, int course, double averageMark) {
        this.name = name;
        this.course = course;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", averageMark=" + averageMark +
                '}';
    }
}
