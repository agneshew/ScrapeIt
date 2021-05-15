package com.agnes.ScrapeIt.response;

import com.agnes.ScrapeIt.model.FileModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
public class ListResponse {

    FileModel fileModel = new FileModel();

    String id = fileModel.getFileId();
    String name = fileModel.getFileName();

    public ListResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
