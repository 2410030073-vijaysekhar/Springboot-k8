package com.example.skill7.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.skill7.model.Course;
import com.example.skill7.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        service.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = service.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated != null) {
            return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        String result = service.deleteCourse(id);
        if (result.contains("successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchByTitle(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}