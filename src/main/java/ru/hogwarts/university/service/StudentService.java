package ru.hogwarts.university.service;

import ru.hogwarts.university.exception.StudentNotFoundException;
import ru.hogwarts.university.model.Student;

import java.util.Collection;

public interface StudentService {
    Student getStudentById(Long studentId);
    Collection<Student> getAllStudents();
}
