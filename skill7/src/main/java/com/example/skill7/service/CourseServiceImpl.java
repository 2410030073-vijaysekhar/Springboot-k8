package com.example.skill7.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.skill7.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

    private List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        return courses.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course updateCourse(int id, Course course) {
        Course existing = getCourseById(id);
        if (existing != null) {
            existing.setTitle(course.getTitle());
            existing.setDuration(course.getDuration());
            existing.setFee(course.getFee());
            return existing;
        }
        return null;
    }

    public String deleteCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            courses.remove(course);
            return "Course deleted successfully";
        }
        return "Course not found";
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}