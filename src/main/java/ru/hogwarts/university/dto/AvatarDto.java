package ru.hogwarts.university.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AvatarDto {
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;

    public AvatarDto(Long id, String filePath, long fileSize, String mediaType) {
        this.id = id;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
    }
}
