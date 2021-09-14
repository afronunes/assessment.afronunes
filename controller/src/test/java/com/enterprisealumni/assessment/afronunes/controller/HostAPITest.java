/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.config.FileConfig;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The purpose of this class is to test  {@link HostAPI#hosts()}.
 */
public class HostAPITest {

    HostAPI hostController;

    @Mock
    private HostService hostService;

    MockMvc mockMvc;

    @Mock
    FileConfig fileConfig;

    @Before
    public void setUp() throws Exception {
        hostController = new HostAPI(hostService,fileConfig);

        when(fileConfig.getFileName()).thenReturn("Coding_Demo_Data.txt");

        mockMvc = MockMvcBuilders.standaloneSetup(hostController).build();
    }

    // TODO @Test - same idea from services test. Please check {@link HostServiceTest}
    public void getHostsFromFile() throws Exception {
        mockMvc.perform(get(HostAPI.URL_HOSTS))
                .andExpect(status().isOk());
    }
}