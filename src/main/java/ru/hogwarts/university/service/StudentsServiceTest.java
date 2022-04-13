package ru.hogwarts.university.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.university.model.Student;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Profile("test")
// что будет если в app test prop будет настройка, а в app prop не будет
public class StudentsServiceTest implements StudentService{
    @Override
    public Student getStudentById(Long studentId) {
        Student student = new Student();
        student.setId(0L);
        student.setName("TestStudent");
        return student;
    }

    @Override
    public Collection<Student> getAllStudents() {
        Collection<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(0L);
        student.setName("TestStudent");
        students.add(student);
        return students;
    }
}
