package ru.hogwarts.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student);
        if (updateStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(name = "id") Long studentId) {
        Student deletedStudent = studentService.deleteStudent(studentId);
        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping("/getByAge/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return studentService.getByAge(age);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
