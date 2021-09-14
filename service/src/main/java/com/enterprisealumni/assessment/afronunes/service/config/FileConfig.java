/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Load file demo name
 */
@PropertySource("classpath:service.properties")
@Configuration
public class FileConfig {

    @Value( "${file.name}" )
    private String fileName;

    public String getFileName() {
        return fileName;
    }
}
