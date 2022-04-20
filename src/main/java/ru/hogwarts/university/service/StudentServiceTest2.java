package ru.hogwarts.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.university.model.Student;

@Service
@Profile("!test")
public class StudentServiceTest2 implements StudentServiceTest {
    Logger logger = LoggerFactory.getLogger(StudentServiceTest1.class);
    @Override
    public Student getStudentByIdTest(Long studentId) {
        logger.info("test2 method for get Student by id:{} was invoked", studentId);
        Student student = new Student();
        student.setId(0L);
        student.setName("TestStudent2");
        return student;
    }

}
