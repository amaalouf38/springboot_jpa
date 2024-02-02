package springbootjpa.springbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootjpa.springbootjpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}