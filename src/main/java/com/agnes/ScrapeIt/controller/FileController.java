package com.agnes.ScrapeIt.controller;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.response.MessageResponse;
import com.agnes.ScrapeIt.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileService.saveFile(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }
    @GetMapping("/files")
    public ResponseEntity<Iterable<FileModel>> getListOfFiles() {
        return ResponseEntity.ok(fileService.getListOfFiles());
    }
    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable Long id) {
        FileModel fileModel = fileService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getFileName() + "\"")
                .body(fileModel.getContent());
    }
}





