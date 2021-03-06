package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColourIgnoreCase(String colour);
    List<Faculty> findByNameIgnoreCaseOrColourIgnoreCase(String name, String colour);
    List<Faculty> findByNameIgnoreCase(String name);
}
