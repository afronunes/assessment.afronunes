package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * The purpose of this class is to test  {@link HostAPI#hosts()}.
 */
public class HostAPITest {

    HostAPI hostController;

    @Mock
    private HostService hostService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        hostController = new HostAPI(hostService);

        // same idea from services test.
        //when(hostService.getHostsFromFile();

        mockMvc = MockMvcBuilders.standaloneSetup(hostController).build();
    }

    // TODO @Test - same idea from services test. Please check {@link HostServiceTest}
    public void getHostsFromFile() throws Exception{
        mockMvc.perform(get(HostAPI.URL_HOSTS))
                .andExpect(status().isOk());
    }
}