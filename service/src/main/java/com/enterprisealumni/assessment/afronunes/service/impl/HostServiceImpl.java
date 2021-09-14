package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.factory.HostFactory;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    final FileService fileService;

    public HostServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public List<Host> getHostsFromFile(String pFileName, final HostFilesType pHostFilesType) {

        final List<Host> hosts = new ArrayList<>();

        final File file = fileService.loadFile(DirectoryType.INPUT, pFileName);

        try {
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);

            lines.forEach(line -> {
                hosts.add(HostFactory.createHost(line, pHostFilesType));
            });

        }
        catch (IOException e) {
            // TODO - Default APP Error Handle to be implemented
            e.printStackTrace();
        }

        return hosts;
    }


}
