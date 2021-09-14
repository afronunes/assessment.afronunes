/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service;

import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;

import java.util.List;

public interface HostService {
    public List<Host> getHostsFromFile(final  String pFileName, final HostFilesType pHostFilesType);
}
