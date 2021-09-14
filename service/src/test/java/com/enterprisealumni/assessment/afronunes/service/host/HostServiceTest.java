/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.host;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.TestUtils;
import com.enterprisealumni.assessment.afronunes.service.impl.HostServiceImpl;
import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URI;
import java.net.URL;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * The purpose of this class is to test  {@link HostServiceImpl#getHostsFromFile(String, HostFilesType)}.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootApplication
public class HostServiceTest {

    private HostService hostService;

    final private String FILE_NAME = "Coding_Demo_Data.txt";

    final ClassLoader classLoader = getClass().getClassLoader();

    private File file;

    @Mock
    private FileService fileService;

    private HostMapper hostMapper = HostMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {

        // simple instance
        hostService = new HostServiceImpl(fileService,hostMapper);

        // mock fileService
        when(fileService.loadFile(Matchers.any(DirectoryType.class), anyString())).thenReturn(getMockedFile());

    }

    @Test
    public void readLines() {
        hostService.getHostsFromFile(FILE_NAME, HostFilesType.DEFAULT);
    }

    /**
     * Returns a file mocked
     *
     * @return
     * @throws Exception
     */
    private File getMockedFile() throws Exception {

        // initial config
        final URL url = classLoader.getResource(DirectoryType.INPUT.getPath());
        final File parentFolder = new File(new URI(url.toString()));
        final File newFile = new File(parentFolder, FILE_NAME);

        // create file
        FileUtils.touch(newFile);

        // write on it
        FileUtils.writeLines(newFile, TestUtils.getFileLines());

        return newFile;
    }

}