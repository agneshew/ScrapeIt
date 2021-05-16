package com.agnes.ScrapeIt.service;

import com.agnes.ScrapeIt.config.FileErrors;
import com.agnes.ScrapeIt.config.FileSaveException;
import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public FileModel saveFile(MultipartFile multipartFile) {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if (filename.contains("...")) {
                throw new FileSaveException(FileErrors.INVALID_FILE + filename);
            }
            FileModel fileModel = new FileModel();
            Path pathFile = Paths.get(convert(multipartFile).getAbsolutePath());
            fileModel.setFileName(filename);
            fileModel.setContent(multipartFile.getBytes());
            fileModel.setNumRows(Files.lines(pathFile, StandardCharsets.UTF_8).count());
            fileModel.setSize(multipartFile.getSize());
            fileModel.setCratedAt(new Date());

            return fileRepository.save(fileModel);
        } catch (Exception e) {
            throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
        }
    }
    public File convert(MultipartFile m) throws IOException {
        File convFile = new File(m.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(m.getBytes());
        fos.close();
        return convFile;
    }
    public List<FileModel> getListOfFiles() {
        return fileRepository.findAll();
    }
    public FileModel getFile(Long id) {
        return fileRepository.findById(id).get();
    }
}
