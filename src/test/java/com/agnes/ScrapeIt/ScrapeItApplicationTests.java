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
import java.nio.file.Files;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
class ScrapeItApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private FileRepository fileRepository;

	@Test
	@Rollback(false)
	//void contextLoads() { }
	void testInsertFile() throws IOException {
		File file = new File("/Users/agnieszkahewusz/Desktop/abc.rtf");
		FileModel testFile = new FileModel();
		testFile.setFileName(file.getName());

		byte[] bytes = Files.readAllBytes(file.toPath());
		testFile.setFileData(bytes);

		FileModel savedFile = fileRepository.save(testFile);

		FileModel existFile = testEntityManager.find(FileModel.class, savedFile.getFileId());

		assertEquals(existFile.getFileName(), file.getName());
	}
}
