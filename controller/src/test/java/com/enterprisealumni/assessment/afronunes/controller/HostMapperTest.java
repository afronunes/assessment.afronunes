package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.controller.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.controller.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.impl.FileServiceImpl;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The purpose of this class is to test {@link HostMapper#hostToHostDTO(Host)}
 */
public class HostMapperTest {

    private final HostMapper hostMapper = HostMapper.INSTANCE;

    private Host host = new Host();

    private String HOST_NAME = "hostName";
    private BigDecimal HOST_MIN = new BigDecimal(4);
    private BigDecimal HOST_MAX = new BigDecimal(10);
    private BigDecimal HOST_AVERAGE = new BigDecimal(10);

    @Before
    public void setUp() {
        host.setName(HOST_NAME);
        host.setMin(HOST_MIN);
        host.setMax(HOST_MAX);
        host.setAverage(HOST_AVERAGE);
    }

    @Test
    public void hostToHostDTO() {

        final HostDTO hostDTO = hostMapper.hostToHostDTO(host);

        assertEquals(hostDTO.getName(), HOST_NAME);
        assertTrue(hostDTO.getMax().compareTo(HOST_MAX) == 0);
        assertTrue(hostDTO.getMin().compareTo(HOST_MIN) == 0);
        assertTrue(hostDTO.getAverage().compareTo(HOST_AVERAGE) == 0);

    }
}