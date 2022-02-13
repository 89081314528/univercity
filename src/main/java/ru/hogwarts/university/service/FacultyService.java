package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFoundException;
import ru.hogwarts.university.exception.NameAndColourIsNullException;
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
        Faculty faculty = facultyRepository.findById(facultyId).orElse(null);
        if (faculty == null) {
            throw new FacultyNotFoundException();
        }
        return faculty;
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).orElse(null);
        if (faculty == null) {
            throw new FacultyNotFoundException();
        }
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getByColour(String colour) {
        return facultyRepository.findByColourIgnoreCase(colour);
    }

    public List<Faculty> findByNameOrColour(String name, String colour) {
        if (name == null && colour != null) {
            return facultyRepository.findByColourIgnoreCase(colour);
        }
        if (name != null && colour == null) {
            return facultyRepository.findByNameIgnoreCase(name);
        }
        if (name == null && colour == null) {
            throw new NameAndColourIsNullException();
        }
        return facultyRepository.findByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }
}
