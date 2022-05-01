package ru.hogwarts.university.service;

import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student getStudentById(Long studentId);
    Collection<Student> getAllStudents();

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);

    List<Student> getByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    List<Student> getByName(String name);

    int getQuantityOfStudents();

    int getAverageAge();

    List<LastFive> getLastFive();

    List<Student> getLastFive2();

    List<String> namesStartWith(String letter);

    double averageAgeByStream();

    void namesByThread();

    void namesBySynchronizedThread();
}
