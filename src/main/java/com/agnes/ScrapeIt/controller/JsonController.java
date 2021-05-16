package com.agnes.ScrapeIt.controller;

import com.agnes.ScrapeIt.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    JsonService jsonService;

    @GetMapping("/list")
    public String getJsonListFiles(Model model) {
        String listFiles = jsonService.getListFilesJson();
        return listFiles;
    }
    @GetMapping("/{id}")
    public String getJsonListFiles(Model model, @PathVariable Long id) {
        String file = jsonService.getFileJson(id);
        return file;
    }
}
