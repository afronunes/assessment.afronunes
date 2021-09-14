/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

@Service
public class FileServiceImpl implements FileService {

    final ClassLoader classLoader = getClass().getClassLoader();

    ResourceLoader resourceLoader;

    public FileServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public File createFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception {

        final URL url = classLoader.getResource(pDirectoryType.getPath());

        final File parentFolder = new File(new URI(url.toString()));

        final File newFile = new File(parentFolder, pFileName);

        FileUtils.touch(newFile);

        return newFile;

    }

    @Override
    public InputStream loadFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception {
        return resourceLoader.getResource(CLASS_PATH + pDirectoryType.getPath() + pFileName).getInputStream();
    }
}
