package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFound;
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
            throw new FacultyNotFound();
        }
        return faculty;
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).orElse(null);
        if (faculty == null) {
            throw new FacultyNotFound();
        }
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getByColour(String colour) {
        return facultyRepository.findByColour(colour);
    }

    //в методе делать строку с sql запросом либо where color = where name =
    public List<Faculty> findByNameOrColour(String name, String colour) {
        return facultyRepository.findByNameIgnoreCaseOrColourIgnoreCase(name, colour);
    }
}
