/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.impl;

import com.enterprisealumni.assessment.afronunes.service.FileService;
import com.enterprisealumni.assessment.afronunes.service.config.FileConfig;
import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {

    final ClassLoader classLoader = getClass().getClassLoader();

    ResourceLoader resourceLoader;

    /**
     * Constructor for FileServiceImpl
     *
     * @param pResourceLoader
     * @param fileConfig
     */
    public FileServiceImpl(final ResourceLoader pResourceLoader, FileConfig fileConfig) {
        this.resourceLoader = pResourceLoader;
    }

    @Override
    public InputStream loadFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception {
        return resourceLoader.getResource(CLASS_PATH + pDirectoryType.getPath() + pFileName).getInputStream();
    }
}
