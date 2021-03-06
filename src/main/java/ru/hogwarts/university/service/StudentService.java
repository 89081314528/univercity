package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.exception.AgeIsNotCorrectException;
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
        return studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new StudentNotFoundException();
        }
        studentRepository.deleteById(studentId);
    }

    public List<Student> getByAge(int age) {
        return studentRepository.getByAge(age);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min, int max) {
        if(min > max) {
            throw new AgeIsNotCorrectException();
        }
        return studentRepository.findByAgeBetween(min, max);
    }

    public List<Student> getByName(String name) {
        return studentRepository.getByName(name);
    }

    public int getQuantityOfStudents() {
        return studentRepository.getQuantityOfStudents();
    }

    public int getAverageAge() {
        return studentRepository.getAverageAge();
    }

    public List<LastFive> getLastFive() {
        return studentRepository.getLastFive();
    }

    public List<Student> getLastFive2() {
        return studentRepository.getLastFive2();
    }
}
