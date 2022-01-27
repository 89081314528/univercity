package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
