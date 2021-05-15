package com.agnes.ScrapeIt.response;

import com.agnes.ScrapeIt.model.FileModel;
import lombok.Getter;

@Getter
public class FileResponse {

    FileModel fileModel = new FileModel();

    String fileId = fileModel.getFileId();
    String fileName = fileModel.getFileName();
    String fileType = fileModel.getFileType();

    public FileResponse(String fileId, String fileName, String fileType) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
    }
}
