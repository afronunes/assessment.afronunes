/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;

import java.io.InputStream;
import java.util.List;

/**
 * Host Service
 */
public interface HostService {

    List<HostDTO> getHostsFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception;

    InputStream getHostsFileFromFile(final String pFileName, final HostFilesType pHostFilesType) throws Exception;
}
