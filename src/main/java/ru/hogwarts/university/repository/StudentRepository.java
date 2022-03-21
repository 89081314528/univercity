package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.university.dto.LastFive;
import ru.hogwarts.university.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getByAge(int age);
    List<Student> findByAgeBetween(int min, int max);

    @Query(value = "select count(*) from student", nativeQuery = true)
    int getQuantityOfStudents();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    int getAverageAge();

    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    List<LastFive> getLastFive();

    @Query(value = "select s from Student s order by id desc") // 2 вариант с gpql, в нем нет limit
    List<Student> getLastFive2();

}
