/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.factory.HostFactory;
import com.enterprisealumni.assessment.afronunes.service.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.singleton.StreamSingleton;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HostServiceImpl implements HostService {

    final FileService fileService;

    private final HostMapper hostMapper;

    public HostServiceImpl(FileService fileService, HostMapper hostMapper) {
        this.fileService = fileService;
        this.hostMapper = hostMapper;
    }

    @Override
    public List<HostDTO> getHostsFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception {

        final List<Host> hosts = new ArrayList<>();

        final InputStream fileInputStream = fileService.loadFile(DirectoryType.INPUT, pFileName);

        try {

            List<String> lines = StreamSingleton.getInstance().readLinesFromInputStream(fileInputStream);

            lines.forEach(line -> {
                hosts.add(HostFactory.createHost(line, pHostFilesType));
            });

            // convert to DTO
            final List<HostDTO> hostsDTO = hosts.stream().map(hostMapper::hostToHostDTO).collect(Collectors.toList());

            // sort
            Collections.sort(hostsDTO);

            return hostsDTO;

        } catch (IOException e) {
            // TODO - Default APP Error Handle to be implemented
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InputStream getHostsFileFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception {

        final List<HostDTO> hosts = getHostsFromFile(pFileName, pHostFilesType);

        final List<String> lines = hosts.stream().map(HostDTO::getFullInfo).collect(Collectors.toList());

        return  StreamSingleton.getInstance().getInputStream(lines);

    }

}
