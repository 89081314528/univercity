package ru.hogwarts.university.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/students/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return studentService.getByAge(age);
    }

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/ageBetween")
    public Collection<Student> findByAgeBetween(@RequestParam int min,@RequestParam int max) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping("/students/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return studentService.getByName(name);
    }
  
    @GetMapping("/quantityOfStudents")
    public int getQuantityOfStudents() {
        return studentService.getQuantityOfStudents();
    }

    @GetMapping("/averageAge")
    public int getAverageAge() {
        return studentService.getAverageAge();
    }

    @GetMapping("/lastFive")
    public List<LastFive> getLastFive() {
        return studentService.getLastFive();
    }

    @GetMapping("/lastFive2")
    public List<Student> getLastFive2() {
        return studentService.getLastFive2();
    }
}
