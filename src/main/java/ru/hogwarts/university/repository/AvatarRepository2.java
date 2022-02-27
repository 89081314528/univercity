package ru.hogwarts.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwarts.university.model.Avatar;

public interface AvatarRepository2 extends PagingAndSortingRepository<Avatar, Long> {
}
