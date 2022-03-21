package ru.hogwarts.university.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Data
@RequiredArgsConstructor
public class AvatarDto {
    private final Long id;
    private final String filePath;
    private final long fileSize;
    private final String mediaType;

}
