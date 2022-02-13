package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.FacultyNotFoundException;
import ru.hogwarts.university.exception.StudentNotFoundException;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
        return student;
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(FacultyNotFoundException::new);
        studentRepository.deleteById(studentId);
    }

    public List<Student> getByAge(int age) {
        return studentRepository.getByAge(age);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
