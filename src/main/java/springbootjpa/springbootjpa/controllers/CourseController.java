package springbootjpa.springbootjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springbootjpa.springbootjpa.model.Course;
import springbootjpa.springbootjpa.repositories.CourseRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Create a new course
    @PostMapping("/")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    @GetMapping("/")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get a single course by id
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
            @RequestBody Course courseDetails) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (!courseOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Course course = courseOptional.get();
        course.setName(courseDetails.getName());
        // Update other fields as necessary
        final Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(value = "id") Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseRepository.delete(course.get());
        return ResponseEntity.ok().build();
    }
}
