package ru.hogwarts.university.model;

import javax.persistence.*;

@Entity
public class Avatar {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "filePath")
    private String filePath;
    @Column(name = "fileSize")
    private long fileSize;
    @Column(name = "mediaType")
    private String mediaType;
    @Column(name = "data")
    @Lob
    private byte[] data;
    @OneToOne
    private Student student;

    public Avatar() {
    }

    public Avatar(Long id, String filePath, long fileSize, String mediaType, byte[] data, Student student) {
        this.id = id;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.data = data;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
