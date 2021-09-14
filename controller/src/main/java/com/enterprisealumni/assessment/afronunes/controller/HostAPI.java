/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HostAPI {

    // clearly can be located in a better place :)
    public final static String URL_HOSTS = "/hosts";
    public final static String URL_HOSTS_JSON = URL_HOSTS + "/json";
    public final static String URL_HOSTS_FILE = URL_HOSTS + "/file";
    public final static String MODEL_HOST = "hosts";

    /**
     * HostService injected by constructor
     */
    private HostService hostService;

    public HostAPI(final HostService pHostService) {
        this.hostService = pHostService;
    }

    @GetMapping(path = URL_HOSTS_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<HostDTO> hostsJson() {

        return hostService.getHostsFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);

    }

    @GetMapping(path = URL_HOSTS, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String hosts() {

        final List<HostDTO> hostsDTOS = hostService.getHostsFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);
        return hostsDTOS.stream().map(HostDTO::getFullInfo).collect(Collectors.joining("|"));

    }

    @GetMapping(path = URL_HOSTS_FILE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InputStreamResource> hostsFile() throws Exception {

        // get Hosts file
        final InputStreamResource fileStream;
        try {
            fileStream = hostService.getHostsFileFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(fileStream);
        } catch (FileNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
