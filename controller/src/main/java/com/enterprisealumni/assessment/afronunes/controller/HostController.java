package com.enterprisealumni.assessment.afronunes.controller;

import com.enterprisealumni.assessment.afronunes.controller.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.controller.mapper.HostMapper;
import com.enterprisealumni.assessment.afronunes.service.HostService;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HostController {

    /**
     * HostService injected by constructor
     */
    private HostService hostService;

    /**
     * Host Mapper injected by constructor
     */
    private HostMapper hostMapper;

    public HostController(final HostService pHostService, final HostMapper pHostMapper) {
        this.hostService = pHostService;
        this.hostMapper = pHostMapper;
    }

    /**
     * Return HostsDTO from file.
     *
     * @param pFileName
     * @return
     */
    @GetMapping("/hosts")
    public List<HostDTO> getHostsFromFile(final String pFileName){

        // get Hosts
        final List<Host> hosts = hostService.getHostsFromFile(pFileName, HostFilesType.DEFAULT);

        // convert to DTO
        return hosts.stream().map(hostMapper::hostToHostDTO).collect(Collectors.toList());
    }

}
