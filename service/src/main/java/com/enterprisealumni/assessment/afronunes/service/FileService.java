/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.type.DirectoryType;

import java.io.File;

/**
 * File Service
 */
public interface FileService {

    public File createFile(final DirectoryType pDirectoryType, final String pFileName) throws Exception;

    public File loadFile(final DirectoryType pDirectoryType, final String pFileName);

}
