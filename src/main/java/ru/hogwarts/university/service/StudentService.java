package ru.hogwarts.university.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.university.exception.StudentNotFoundException;
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
        Student student = studentMap.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        return student;
    }

    public Student updateStudent(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            throw new StudentNotFoundException();
        }
        studentMap.put(student.getId(), student);
        return student;
    }

    public void deleteStudent(Long studentId) {
        Student student = studentMap.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        studentMap.remove(studentId);
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
        return new ArrayList<>(studentMap.values());
    }
}
