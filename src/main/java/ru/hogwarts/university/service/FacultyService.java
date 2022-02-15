package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFoundException;
import ru.hogwarts.university.model.Faculty;
import ru.hogwarts.university.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(FacultyNotFoundException::new);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) { // existByld
        Faculty faculty = facultyRepository.findById(facultyId).orElseThrow(FacultyNotFoundException::new);
        facultyRepository.deleteById(facultyId);
    }

    public List<Faculty> getByColour(String colour) {
        return facultyRepository.findByColour(colour);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
