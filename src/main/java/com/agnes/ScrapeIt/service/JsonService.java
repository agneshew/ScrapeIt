package com.agnes.ScrapeIt.service;

import com.agnes.ScrapeIt.repository.JsonListRepository;
import com.agnes.ScrapeIt.response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonService {

    @Autowired
    JsonListRepository jsonListRepository;

    public List<ListResponse> getListFilesJson() {
        return jsonListRepository.findAll();
    }
}
