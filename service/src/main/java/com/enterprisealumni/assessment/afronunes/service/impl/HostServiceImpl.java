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
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.*;
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
    public List<HostDTO> getHostsFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception {

        final List<Host> hosts = new ArrayList<>();

        final  InputStream fileInputStream = fileService.loadFile(DirectoryType.INPUT, pFileName);

        try {

            List<String> lines = readLinesFromInputStream(fileInputStream);

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
    public InputStream getHostsFileFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception {

        final List<HostDTO> hosts = getHostsFromFile(pFileName, pHostFilesType);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            final List<String> lines = hosts.stream().map(HostDTO::getFullInfo).collect(Collectors.toList());

            final byte[] lineSeparator = System.lineSeparator().getBytes();

            for (String line : lines) {
                out.write(line.getBytes());
                out.write(lineSeparator);
            }

            return new ByteArrayInputStream(out.toByteArray());

        }
        catch(Exception ex) {
            throw ex;
        }

        finally {
            if(out!=null) out.close();
        }

    }

    private List<String> readLinesFromInputStream(InputStream inputStream)
            throws IOException {

        List<String> lines = new ArrayList<>();

        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.concat("\n"));
            }
        }
        return lines;
    }


}
