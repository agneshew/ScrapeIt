package com.agnes.ScrapeIt;

import com.agnes.ScrapeIt.model.FileModel;
import com.agnes.ScrapeIt.repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ScrapeItApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private FileRepository fileRepository;

	@Test
	@Rollback(false)
	void testInsertFile() throws IOException {
		Path pathTestFile = Paths.get("/Users/agnieszkahewusz/Desktop/abc.rtf");
		File file = new File(pathTestFile.toString());
		FileModel testFile = new FileModel();
		testFile.setFileName(file.getName());

		byte[] bytes = Files.readAllBytes(file.toPath());
		testFile.setContent(bytes);
		long fileSize = bytes.length;
		testFile.setSize(fileSize);
		testFile.setCratedAt(new Date());
		testFile.setNumRows(Files.lines(pathTestFile, StandardCharsets.UTF_8).count());
		FileModel savedFile = fileRepository.save(testFile);

		FileModel existFile = testEntityManager.find(FileModel.class, savedFile.getFileId());

		assertEquals(existFile.getSize(), fileSize);
	}
}
