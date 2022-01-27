package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
