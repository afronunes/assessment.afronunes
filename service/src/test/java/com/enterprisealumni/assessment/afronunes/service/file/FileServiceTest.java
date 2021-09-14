/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.file;

import com.enterprisealumni.assessment.afronunes.service.impl.FileServiceImpl;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * The purpose of this class is to test {@link FileServiceImpl#createFile(DirectoryType, String)} and {@link FileServiceImpl#loadFile(DirectoryType, String)}.
 * Its conception takes into account the importance of the test being independent
 * and not leaving residues after its execution
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootApplication
public class FileServiceTest {

    final private String NAME_TEST_FILE = "File_Test_Data.txt";

    final private String FULL_PATH_TEST_FILE = DirectoryType.INPUT.getPath() + NAME_TEST_FILE;

    FileServiceImpl fileService;

    File fileTest;

    @Before
    public void setUp() throws Exception {
        // no need to mock right now
        fileService = new FileServiceImpl();
    }

    @Test
    public void createFile() {
        try {
            fileTest = fileService.createFile(DirectoryType.INPUT, NAME_TEST_FILE);
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void loadFile() {

        this.createFile();

        File file = fileService.loadFile(DirectoryType.INPUT, NAME_TEST_FILE);
        assertEquals(file.getName(), NAME_TEST_FILE);
    }

    @Test
    public void loadAppFile() {

        this.createFile();

        File file = fileService.loadFile(DirectoryType.INPUT, "Coding_Demo_Data.txt");
        assertEquals(file.getName(), "Coding_Demo_Data.txt");

    }

    @After
    public void deleteFiles() {
        FileUtils.deleteQuietly(fileTest);
    }

}