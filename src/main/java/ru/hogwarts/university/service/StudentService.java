package ru.hogwarts.university.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.university.model.Student;

import java.util.*;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private Long studentId = 1L;

    public Student createStudent(Student student) {
        student.setId(studentId);
        studentMap.put(studentId, student);
        studentId++;
        return student;
    }

    public Student getStudentById(Long studentId) {
        return studentMap.get(studentId);
    }

    public Student updateStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(Long studentId) {
        return studentMap.remove(studentId);
    }

    public List<Student> getByAge(int age) {
        Collection<Student> allStudents = studentMap.values();
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }
}
