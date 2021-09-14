/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.factory;

import com.enterprisealumni.assessment.afronunes.service.TestUtils;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.singleton.ValueBusinessSingleton;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The purpose of this class is to test  {@link HostFactory#createHost(String, HostFilesType)}
 *
 * Can be improved with more elaborated tests.
 */
@SpringBootTest
public class HostFactoryTest {

    @Test
    public void createHosts() {

        TestUtils.getFileLines().forEach(line -> {
            final Host host = HostFactory.createHost(line,HostFilesType.DEFAULT);
            assertEquals(host.getName(),line.substring(0,3));
        });
    }
}