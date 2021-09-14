package com.enterprisealumni.assessment.afronunes.bootstrap;

import com.enterprisealumni.assessment.afronunes.Application;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import org.junit.runner.RunWith;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class AssessmentBootstrapTest {


    @Before
    public void b() {
        System.out.println("a");
    }


    @Test
    public void readFile() {
        String expectedData = "Hello, world!";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/input/Coding_Demo_Data.txt").getFile());
        String data = null;
        try {
            data = FileUtils.readFileToString(file, "UTF-8");


        } catch (IOException e) {
            assert false;
        }

        assertEquals(expectedData, data.trim());
    }

}