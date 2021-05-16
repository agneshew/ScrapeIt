package com.agnes.ScrapeIt.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "files")
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "file_ID", nullable = false, unique = true)
    private Long fileId;

    @Column(name ="file_name")
    private String fileName;

    @Column(name="number_of_rows")
    private long numRows;

    @Column(name = "created_at")
    private Date cratedAt;

    @Column(name = "size")
    private long size;
    @Lob
    @Column(name = "content")
    private byte[] content;

    public FileModel() {
    }

    public FileModel(Long fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }
}

