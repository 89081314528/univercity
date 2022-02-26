package ru.hogwarts.university.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.university.model.Avatar;

import java.io.IOException;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
}
