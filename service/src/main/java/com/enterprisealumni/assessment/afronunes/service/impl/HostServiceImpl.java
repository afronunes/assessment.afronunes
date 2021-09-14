/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.factory.HostFactory;
import com.enterprisealumni.assessment.afronunes.service.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HostServiceImpl implements HostService {

    final FileService fileService;

    private HostMapper hostMapper;

    public HostServiceImpl(FileService fileService, HostMapper hostMapper) {
        this.fileService = fileService;
        this.hostMapper = hostMapper;
    }

    @Override
    public List<HostDTO> getHostsFromFile(final String pFileName, final HostFilesType pHostFilesType) {

        final List<Host> hosts = new ArrayList<>();

        final File file = fileService.loadFile(DirectoryType.INPUT, pFileName);

        try {
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);

            lines.forEach(line -> {
                hosts.add(HostFactory.createHost(line, pHostFilesType));
            });

            // convert to DTO
            final List<HostDTO> hostsDTO = hosts.stream().map(hostMapper::hostToHostDTO).collect(Collectors.toList());

            // sort
            Collections.sort(hostsDTO);

            return hostsDTO;

        }
        catch (IOException e) {
            // TODO - Default APP Error Handle to be implemented
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InputStreamResource getHostsFileFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception {

        final List<HostDTO> hosts = getHostsFromFile(pFileName, pHostFilesType);

        // create file
        final File hostFile = fileService.createFile(DirectoryType.OUTPUT,"host_file_out.txt");

        FileUtils.writeLines(hostFile,hosts.stream().map(HostDTO::getFullInfo).collect(Collectors.toList()));

        InputStreamResource fileResource = new InputStreamResource(new FileInputStream(hostFile));

        FileUtils.deleteQuietly(hostFile);

        return  fileResource;

    }


}
