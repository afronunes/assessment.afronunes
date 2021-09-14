/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.host;

import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.TestUtils;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.impl.HostServiceImpl;
import com.enterprisealumni.assessment.afronunes.service.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.singleton.StreamSingleton;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * The purpose of this class is to test  {@link HostServiceImpl#getHostsFromFile(String, HostFilesType)}.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootApplication
public class HostServiceTest {

    private HostService hostService;

    final StreamSingleton streamSingleton = StreamSingleton.getInstance();

    @Mock
    private FileService fileService;

    private final HostMapper hostMapper = HostMapper.INSTANCE;

    private List<String>  mockFile = TestUtils.getFileLines();

    @Before
    public void setUp() throws Exception {
        // simple instance
        hostService = new HostServiceImpl(fileService, hostMapper);
        when(fileService.loadFile(any(),anyString())).thenReturn(TestUtils.getMockedFile());
    }

    @Test
    public void loadHostsDTO() throws Exception {

        final List<HostDTO> hosts = hostService.getHostsFromFile("FILE_NAME", HostFilesType.DEFAULT);

        // check hosts loads
        hosts.forEach(host ->{
            final String lineFound = mockFile.stream().filter(line -> line.contains(host.getName())).findFirst().orElse(null);
            Assert.assertNotNull(lineFound);
        });
    }

}