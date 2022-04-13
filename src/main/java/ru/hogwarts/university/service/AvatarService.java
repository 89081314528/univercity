package ru.hogwarts.university.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.university.dto.AvatarDto;
import ru.hogwarts.university.model.Avatar;

import java.io.IOException;
import java.util.List;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
    List<AvatarDto> getAllAvatarsByPage(int pageNumber, int pageSize);
}
