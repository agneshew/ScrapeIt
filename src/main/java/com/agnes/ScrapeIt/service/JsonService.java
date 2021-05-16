package com.agnes.ScrapeIt.service;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.response.FileResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsonService {

    @Autowired
    FileService fileService;

    public String getListFilesJson() {
        List<FileResponse> files = fileService.getListOfFiles().stream()
                .map(fileModel -> new FileResponse(fileModel.getFileId(), fileModel.getFileName()))
                .collect(Collectors.toList());
        Gson g = new GsonBuilder().create();
        String json = g.toJson(files);
        return json;
    }
    public String getFileJson(Long id) {
        FileModel fileModel = fileService.getFile(id);
        Gson g = new GsonBuilder().create();
        String json = g.toJson(fileModel);
        return json;
    }
}

