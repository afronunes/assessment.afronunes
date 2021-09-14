/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;

import java.io.InputStream;

/**
 * File Service
 */
public interface FileService {

    String CLASS_PATH = "classpath:";

    InputStream loadFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception;

}
