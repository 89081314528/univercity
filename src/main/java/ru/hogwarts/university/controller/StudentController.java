package ru.hogwarts.university.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.service.StudentService;
import ru.hogwarts.university.service.StudentServiceTest;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentServiceTest studentServiceTest;

    public StudentController(StudentService studentService, StudentServiceTest studentServiceTest) {
        this.studentService = studentService;
        this.studentServiceTest = studentServiceTest;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/test/{id}")
    public Student getStudentByIdTest(@PathVariable(name = "id") Long studentId) {
        return studentServiceTest.getStudentByIdTest(studentId);
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

    @GetMapping("/namesStartWith")
    public List<String> namesStartsWith(@RequestParam String letter) {
        return studentService.namesStartWith(letter);
    }

    @GetMapping("/averageAgeByStream")
    public double averageAgeByStream() {
        return studentService.averageAgeByStream();
    }

    @GetMapping("/namesByThread")
    public void namesByThread() { studentService.namesByThread();
    }

    @GetMapping("/namesBySynchronizedThread")
    public void namesBySynchronizedThread() { studentService.namesBySynchronizedThread();
    }

    @GetMapping("/sumFromOneToN")
    public int sumFromOneToN(@RequestParam int n) { return studentService.sumFromOneToN(n);
    }
}
