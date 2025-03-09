package com.francode.hotelBackend.business.mapper;

import com.francode.hotelBackend.business.mapper.generic.Mapper;
import com.francode.hotelBackend.domain.entity.Reservation;
import com.francode.hotelBackend.presentation.dto.request.ReservationRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.ReservationResponseDTO;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ReservationMapper extends Mapper<ReservationRequestDTO, ReservationResponseDTO, Reservation> {

    @Override
    Reservation toEntity(ReservationRequestDTO dto);

    @Override
    ReservationResponseDTO toResponseDTO(Reservation entity);

    @Override
    void updateEntityFromDTO(ReservationRequestDTO dto, @MappingTarget Reservation entity);
}
