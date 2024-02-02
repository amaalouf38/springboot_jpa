package springbootjpa.springbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootjpa.springbootjpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
