package com.example.skill7.service;

import java.util.List;
import com.example.skill7.model.Course;

public interface CourseService {

    Course addCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(int id);
    Course updateCourse(int id, Course course);
    String deleteCourse(int id);
    List<Course> searchByTitle(String title);
}