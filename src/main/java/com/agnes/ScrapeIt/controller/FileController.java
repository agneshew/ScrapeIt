package com.agnes.ScrapeIt.controller;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.response.FileResponse;
import com.agnes.ScrapeIt.service.FileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        FileModel model = fileService.saveFile(file);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").
                path(model.getFileId()).toUriString();
        return new FileResponse(model.getFileName(), fileUri);
    }
    @DeleteMapping("file/{id}")
    public void deleteFileById(@PathVariable String id) {
        fileService.deleteFile(id);
    }
    @GetMapping("/allfiles")
    public  List<FileModel>  getListFiles(Model model) {
        List<FileModel> fileDetails = fileService.getListOfFiles();
        return fileDetails;
    }
//    @GetMapping("/Allfiles/json")
//    public String getJsonListFiles(Model model) {
//        List<FileModel> fileDetails = fileService.getListOfFiles();
//        String json = new Gson().toJson(fileDetails);
//
//        return json;
//    }
}
