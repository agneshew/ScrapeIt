package com.agnes.ScrapeIt.controller;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.response.MessageResponse;
import com.agnes.ScrapeIt.service.FileService;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

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
    @GetMapping("/fileToCSV/{id}")
    public ResponseEntity<Resource> getFileCSV (@PathVariable Long id) throws IOException {
        try {
            FileModel fileModel = fileService.getFile(id);
            String fileName = fileModel.getFileName();
            byte[] fileToCSV = fileModel.getContent();
            Reader reader = new StringReader(new String(fileToCSV));
            InputStream targetStream =
                    new ByteArrayInputStream(CharStreams.toString(reader)
                            .getBytes(Charsets.UTF_8));
            InputStreamResource file = new InputStreamResource(targetStream);
            Reader targetReader = new InputStreamReader(targetStream);
            targetReader.close();
            final CSVParser parser =
                    new CSVParserBuilder()
                            .withSeparator('|')
                            .withIgnoreQuotations(true)
                            .build();
            CSVReader csvReader = new CSVReaderBuilder(targetReader)
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .contentType(MediaType.parseMediaType("application/csv"))
                    .body(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}





