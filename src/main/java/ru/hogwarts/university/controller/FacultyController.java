package ru.hogwarts.university.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.university.model.Faculty;
import ru.hogwarts.university.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable(name = "id") Long facultyId) {
        return facultyService.getFacultyById(facultyId);
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable(name = "id") Long facultyId) {
        facultyService.deleteFaculty(facultyId);
    }

    @GetMapping("/getByColor/{color}")
    public List<Faculty> getByColour(@PathVariable String color) {
        return facultyService.getByColour(color);
    }

    @GetMapping
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/findByNameOrColour")
    List<Faculty> findByNameOrColour(@RequestParam (required = false) String name,
                                                         @RequestParam (required = false) String colour) {
        return facultyService.findByNameOrColour(name, colour);
    }
}
