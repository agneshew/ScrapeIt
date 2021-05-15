package com.agnes.ScrapeIt.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

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
//    @Column(name="number_of_rows")
//    private int numRows;
//    @Column(name = "created_at")
//    private DateFormat cratedAt;
//    @Lob
//    @Column(name = "file_data")
//    private byte[] fileData;

    public FileModel() {
    }
    public FileModel(String fileName) {
        this.fileName = fileName;

    }
}
