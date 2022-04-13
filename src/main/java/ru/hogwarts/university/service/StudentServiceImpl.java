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
        logger.info("Was invoked method for create Student");
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        logger.info("Was invoked method for get Student by id:{}", studentId);
        return studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
        // как в исключение вставить логгер??????
    }

    public Student updateStudent(Student student) {
        logger.info("Was invoked method for update Student");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        logger.info("Was invoked method for delete Student by id:{}", studentId);
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            logger.error("There is not student with id = " + studentId);
            throw new StudentNotFoundException();
        }
        studentRepository.deleteById(studentId);
    }

    public List<Student> getByAge(int age) {
        logger.info("Was invoked method for get Students by age:{}", age);
        return studentRepository.getByAge(age);
    }

    public Collection<Student> getAllStudents() {
        logger.info("Was invoked method for get all Students");
        return studentRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for get Students by age between:{} and {}", min, max);
        if(min > max) {
            logger.error("Min value > " + min + " max value " + max);
            throw new AgeIsNotCorrectException();
        }
        return studentRepository.findByAgeBetween(min, max);
    }

    public List<Student> getByName(String name) {
        logger.info("Was invoked method for get Students by name:{}", name);
        return studentRepository.getByName(name);
    }

    public int getQuantityOfStudents() {
        logger.info("Was invoked method for get quantity of Students");
        return studentRepository.getQuantityOfStudents();
    }

    public int getAverageAge() {
        logger.info("Was invoked method for get average age of Students");
        return studentRepository.getAverageAge();
    }

    public List<LastFive> getLastFive() {
        logger.info("Was invoked method for get last five Students");
        return studentRepository.getLastFive();
    }

    public List<Student> getLastFive2() {
        logger.info("Was invoked method for get last five (second way) Students");
        return studentRepository.getLastFive2();
    }
}
