package ru.hogwarts.university.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.StudentNotFound;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        Student student = studentRepository.getById(studentId);
        if (student == null) {
            throw new StudentNotFound();
        }
        return student;
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.getById(studentId);
        if (student == null) {
            throw new StudentNotFound();
        }
        studentRepository.deleteById(studentId);
    }

    public List<Student> getByAge(int age) {
        Collection<Student> allStudents = studentRepository.findAll();
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
