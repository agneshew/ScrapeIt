package com.agnes.ScrapeIt.repository;

import com.agnes.ScrapeIt.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FileRepository extends JpaRepository<FileModel, Long> {

    @Query("SELECT new FileModel(f.fileId, f.fileName) from FileModel f")
    List<FileModel> findAll();
}
