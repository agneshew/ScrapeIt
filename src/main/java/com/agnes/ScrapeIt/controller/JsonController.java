package com.agnes.ScrapeIt.controller;

import com.agnes.ScrapeIt.response.ListResponse;
import com.agnes.ScrapeIt.service.JsonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
