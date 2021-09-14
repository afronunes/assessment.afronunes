/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.springframework.core.io.InputStreamResource;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Host Service
 */
public interface HostService {

    public List<HostDTO> getHostsFromFile(final  String pFileName, final HostFilesType pHostFilesType);

    public InputStreamResource getHostsFileFromFile(final  String pFileName, final HostFilesType pHostFilesType) throws Exception;
}
