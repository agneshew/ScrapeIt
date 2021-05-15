package com.agnes.ScrapeIt.response;

import com.agnes.ScrapeIt.model.FileModel;
import lombok.Getter;

@Getter
public class FileResponse {

    FileModel fileModel = new FileModel();

    String fileId = fileModel.getFileId();
    String fileName = fileModel.getFileName();

    public FileResponse(String fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }
}
