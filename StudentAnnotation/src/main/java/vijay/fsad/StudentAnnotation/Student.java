package vijay.fsad.StudentAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("201")
    private int studentId;

    @Value("vijay")
    private String name;

    private String course;
    private int year;

    @Value("Spring Boot")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("2026")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println(studentId + " " + name + " " + course + " " + year);
    }
}