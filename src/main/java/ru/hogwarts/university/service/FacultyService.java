package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
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
        return facultyMap.get(facultyId);
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty (Long facultyId) {
        return facultyMap.remove(facultyId);
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
        return facultyMap.values();
    }
}
