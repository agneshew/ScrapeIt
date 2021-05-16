package com.agnes.ScrapeIt.response;

import lombok.*;
import java.util.Date;

@Getter
@Setter
public class FileResponse {

    private Long fileId;
    private String fileName;
    private long numRows;
    private Date createdAt;

    public FileResponse(Long fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }
}
