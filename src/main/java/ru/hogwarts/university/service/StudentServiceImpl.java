package ru.hogwarts.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.exception.AgeIsNotCorrectException;
import ru.hogwarts.university.exception.StudentNotFoundException;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.repository.StudentRepository;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public Student createStudent(Student student) {
        logger.info("Method for creating Student was invoked");
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        logger.info("Method for get Student by id:{} was invoked", studentId);
        return studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    logger.error("There is no student with id = " + studentId);
                    return new StudentNotFoundException();
                });
    }

    public Student updateStudent(Student student) {
        logger.info("Method for update Student was invoked");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        logger.info("Method for delete Student by id:{} was invoked", studentId);
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            logger.error("There is no student with id = " + studentId);
            throw new StudentNotFoundException();
        }
        studentRepository.deleteById(studentId);
    }

    public List<Student> getByAge(int age) {
        logger.info("Method for get Students by age:{} was invoked", age);
        return studentRepository.getByAge(age);
    }

    public Collection<Student> getAllStudents() {
        logger.info("Method for get all Students was invoked");
        return studentRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("Method for get Students by age between:{} and {} was invoked", min, max);
        if (min > max) {
            logger.error("Min value > " + min + " max value " + max);
            throw new AgeIsNotCorrectException();
        }
        return studentRepository.findByAgeBetween(min, max);
    }

    public List<Student> getByName(String name) {
        logger.info("Method for get Students by name:{} was invoked", name);
        return studentRepository.getByName(name);
    }

    public int getQuantityOfStudents() {
        logger.info("Method for get quantity of Students was invoked");
        return studentRepository.getQuantityOfStudents();
    }

    public int getAverageAge() {
        logger.info("Method for get average age of Students was invoked");
        return studentRepository.getAverageAge();
    }

    public List<LastFive> getLastFive() {
        logger.info("Method for get last five Students was invoked");
        return studentRepository.getLastFive();
    }

    public List<Student> getLastFive2() {
        logger.info("Method for get last five (second way) Students was invoked");
        return studentRepository.getLastFive2();
    }
}
