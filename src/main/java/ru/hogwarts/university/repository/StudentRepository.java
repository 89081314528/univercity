package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getByAge(int age);
    List<Student> findByAgeBetween(int min, int max);
}
