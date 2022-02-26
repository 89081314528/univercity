package ru.hogwarts.university.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwarts.university.model.Student;

public interface StudentRepository2 extends PagingAndSortingRepository<Student, Long> {

}
