/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;

import java.io.File;
import java.io.InputStream;

/**
 * File Service
 */
public interface FileService {

    final  String CLASS_PATH = "classpath:";

    public File createFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception;

    public InputStream loadFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception;

}
