package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFound;
import ru.hogwarts.university.model.Faculty;
import ru.hogwarts.university.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        if (faculty == null) {
            throw new FacultyNotFound();
        }
        return faculty;
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        if (faculty == null) {
            throw new FacultyNotFound();
        }
        facultyRepository.deleteById(facultyId);
    }

    public List<Faculty> getByColour(String colour) {
        Collection<Faculty> allFaculties = facultyRepository.findAll();
        List<Faculty> facultiesByColour = new ArrayList<>();
        for (Faculty faculty : allFaculties) {
            if (faculty.getColor().equals(colour)) {
                facultiesByColour.add(faculty);
            }
        }
        return facultiesByColour;
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
