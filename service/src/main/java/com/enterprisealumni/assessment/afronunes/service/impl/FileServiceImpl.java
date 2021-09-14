/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;
import java.net.URL;

@Service
public class FileServiceImpl implements FileService {

    final ClassLoader classLoader = getClass().getClassLoader();

    @Override
    public File createFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception {

        final URL url = classLoader.getResource(pDirectoryType.getPath());

        final File parentFolder = new File(new URI(url.toString()));

        final File newFile = new File(parentFolder, pFileName);

        FileUtils.touch(newFile);

        return newFile;

    }

    @Override
    public File loadFile(final DirectoryType pDirectoryType, final String pFileName) {
        return new File(classLoader.getResource(pDirectoryType.getPath() + pFileName).getFile());
    }
}
