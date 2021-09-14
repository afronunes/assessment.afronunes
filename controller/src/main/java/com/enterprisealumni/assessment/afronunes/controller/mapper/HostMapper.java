package com.enterprisealumni.assessment.afronunes.controller.mapper;

import com.enterprisealumni.assessment.afronunes.controller.dto.HostDTO;
import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface HostMapper {

    final HostMapper INSTANCE = Mappers.getMapper(HostMapper.class);

    public HostDTO hostToHostDTO(Host pHost);
}
