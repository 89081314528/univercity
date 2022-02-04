package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFound;
import ru.hogwarts.university.model.Faculty;

import java.util.*;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long facultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(facultyId);
        facultyMap.put(facultyId, faculty);
        facultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        Faculty faculty = facultyMap.get(facultyId);
        if (faculty == null) {
            throw new FacultyNotFound();
        }
        return faculty;
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (!facultyMap.containsKey(faculty.getId())) { //??????
            throw new FacultyNotFound();
        }
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public void deleteFaculty (Long facultyId) { // может возвращать Faculty?
        Faculty faculty = facultyMap.get(facultyId);
        if (faculty == null) {
            throw new FacultyNotFound();
        }
        facultyMap.remove(facultyId);
    }

    public List<Faculty> getByColour(String colour) {
        Collection<Faculty> allFaculties = facultyMap.values();
        List<Faculty> facultiesByColour = new ArrayList<>();
        for (Faculty faculty : allFaculties) {
            if (faculty.getColor().equals(colour)) {
                facultiesByColour.add(faculty);
            }
        }
        return facultiesByColour;
    }

    public Collection<Faculty> getAllFaculties() {
        return new ArrayList<>(facultyMap.values());
    }
}
