/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.factory;

import com.enterprisealumni.assessment.afronunes.service.TestUtils;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The purpose of this class is to test  {@link HostFactory#createHost(String, HostFilesType)}
 * <p>
 * Can be improved with more elaborated tests.
 */
@SpringBootTest
public class HostFactoryTest {

    @Test
    public void createHosts() {

        TestUtils.getFileLines().forEach(line -> {
            final Host host = HostFactory.createHost(line, HostFilesType.DEFAULT);
            assertEquals(host.getName(), line.substring(0, 3));
        });
    }

    @Test
    public void createHostsN32() {

        String line = "n32,1366829460,1366831260,60|None,None,None,None,None,100.0,100.0,99.0,99.0,100.0,99.0,98.0,98.0,82.0,90.0,100.0,81.0,84.0,86.0,97.0,98.0,95.0,90.0,81.0,95.0,89.0,73.0,80.0,100.0,99.0,";

        final Host host = HostFactory.createHost(line, HostFilesType.DEFAULT);

        assertEquals(host.getName(), line.substring(0, 3));
        assertTrue(host.getAverage().compareTo(new BigDecimal("92.52")) == 0);

    }
    @Test
    public void createHostsN11() {

        final String line = "n11,1366829460,1366831260,60|100.0,57.0,84.0,35.0,87.0,67.0,66.0,92.0,39.0,57.0,65.0,65.0,60.0,39.0,89.0,49.0,71.0,77.0,89.0,67.0,74.0,70.0,52.0,69.0,88.0,85.0,99.0,100.0,97.0,97.0,";

        final Host host = HostFactory.createHost(line, HostFilesType.DEFAULT);

        assertTrue(host.getAverage().compareTo(new BigDecimal("72.87")) == 0);
;
    }
}