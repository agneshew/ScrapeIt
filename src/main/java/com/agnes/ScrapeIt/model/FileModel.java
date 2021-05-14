package com.agnes.ScrapeIt.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "files")
public class FileModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    @Column(name = "file_ID")
    private String fileId;
    @Column(name ="file_name")
    private String fileName;
    @Column(name="file_type")
    private String fileType;
    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    public FileModel() {
    }
    public FileModel(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
}
