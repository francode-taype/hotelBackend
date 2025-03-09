package com.francode.hotelBackend.business.mapper;

import com.francode.hotelBackend.business.mapper.generic.Mapper;
import com.francode.hotelBackend.domain.entity.Incident;
import com.francode.hotelBackend.presentation.dto.request.IncidentRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.IncidentResponseDTO;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(componentModel = "spring")
public interface IncidentMapper extends Mapper<IncidentRequestDTO, IncidentResponseDTO, Incident> {

    @Override
    Incident toEntity(IncidentRequestDTO dto);

    @Override
    IncidentResponseDTO toResponseDTO(Incident entity);

    @Override
    void updateEntityFromDTO(IncidentRequestDTO dto, @MappingTarget Incident entity);
}
