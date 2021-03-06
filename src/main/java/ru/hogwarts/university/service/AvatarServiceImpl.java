package ru.hogwarts.university.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.university.dto.AvatarDto;
import ru.hogwarts.university.model.Avatar;
import ru.hogwarts.university.model.Student;
import ru.hogwarts.university.repository.AvatarRepository;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService {
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    private final StudentService studentService;
    private final AvatarRepository avatarRepository;

    public AvatarServiceImpl(StudentService studentService, AvatarRepository avatarRepository) {
        this.studentService = studentService;
        this.avatarRepository = avatarRepository;
    }

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentService.getStudentById(studentId);
        Path filePath = Path.of(avatarsDir, student.getName() + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent()); // создает директорию
        Files.deleteIfExists(filePath); // удаляет файл из директории, если он там есть
        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW); // создает файл в директории
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos); // записывает в файл
        }
        Avatar avatar = findAvatar(studentId);
        if (avatar == null) {
            avatar = new Avatar();
        }
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);
    }

    public Avatar findAvatar(Long studentId) {
        return avatarRepository.findByStudentId(studentId);
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public List<AvatarDto> getAllAvatarsByPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        List<Avatar> avatars = avatarRepository.findAll(pageRequest).getContent();
        List<AvatarDto> avatarDtos = new ArrayList<>();
        for (Avatar avatar : avatars) {
            avatarDtos.add(new AvatarDto(avatar.getId(), avatar.getFilePath(), avatar.getFileSize(), avatar.getMediaType()));
        }
        return avatarDtos;
    }
}
