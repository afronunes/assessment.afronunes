/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service.mapper;

import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.dto.HostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper between {@link HostDTO} and {@link Host}
 */
@Mapper
public interface HostMapper {

    final HostMapper INSTANCE = Mappers.getMapper(HostMapper.class);

    public HostDTO hostToHostDTO(Host pHost);
}
