/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.controller.exception.ErrorLoadingFileException;
import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.config.FileConfig;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
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
    private final HostService hostService;

    /**
     * FileConfig injected by constructor
     */
    private final FileConfig fileConfig;

    /**
     * Contructor for HostAPI
     *
     * @param pHostService
     */
    public HostAPI(final HostService pHostService, final FileConfig pFileConfig) {
        this.hostService = pHostService;
        this.fileConfig = pFileConfig;
    }

    @GetMapping(path = URL_HOSTS_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<HostDTO> hostsJson() throws ErrorLoadingFileException {

        try {
            return hostService.getHostsFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);
        } catch (Exception e) {
            throw new ErrorLoadingFileException();
        }

    }

    @GetMapping(path = URL_HOSTS, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String hosts() throws ErrorLoadingFileException {

        final List<HostDTO> hostsDTOS;
        try {
            hostsDTOS = hostService.getHostsFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);
            return hostsDTOS.stream().map(HostDTO::getFullInfo).collect(Collectors.joining("|"));
        } catch (Exception e) {
            throw new ErrorLoadingFileException();
        }

    }

    @GetMapping(path = URL_HOSTS_FILE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InputStreamResource> hostsFile() throws ErrorLoadingFileException {

        try {

            final InputStream inputStream = hostService.getHostsFileFromFile("Coding_Demo_Data.txt", HostFilesType.DEFAULT);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(inputStream));

        } catch (Exception e) {
            throw new ErrorLoadingFileException();
        }
    }

}
