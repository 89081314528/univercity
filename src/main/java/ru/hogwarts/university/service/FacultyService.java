package ru.hogwarts.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(FacultyNotFoundException::new);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long facultyId) { // existById
        boolean facultyExists = facultyRepository.existsById(facultyId);
        if (!facultyExists) {
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

    public String maxLengthName() {
        List<Faculty> faculties = facultyRepository.findAll();
        Comparator<String> comparator = Comparator.comparing(String::length);
        return faculties.stream()
                .map(Faculty::getName)
                .max(comparator)
                .orElseThrow(); // ???????????????
        // если два факультета с одинаковой длиной названия, какой выберет?
    }
}
