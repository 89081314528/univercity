package ru.hogwarts.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.university.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findByStudentId(Long id);
}
