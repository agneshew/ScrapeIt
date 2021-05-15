package com.agnes.ScrapeIt.service;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.repository.FileRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class JsonService {

    @Autowired
    FileRepository fileRepository;

    public String getListFilesJson() {
        List<FileModel> fileModelList = fileRepository.findAll();
        Gson g = new GsonBuilder().create();
        String json = g.toJson(fileModelList);
        return json;
    }


}
