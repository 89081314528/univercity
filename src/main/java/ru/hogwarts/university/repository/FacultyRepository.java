package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColour(String colour);
}
