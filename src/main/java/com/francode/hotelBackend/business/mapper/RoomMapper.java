package com.francode.hotelBackend.business.mapper;

import com.francode.hotelBackend.domain.entity.Room;
import com.francode.hotelBackend.presentation.dto.request.RoomRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.RoomResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "roomType", ignore = true)
    @Mapping(target = "floor", ignore = true)
    @Mapping(target = "status", source = "status")
    @Mapping(target = "statusCleaning", source = "statusCleaning")
    Room toEntity(RoomRequestDTO dto);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "roomFloorNumber", source = "floor.number")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "statusCleaning", source = "statusCleaning")
    RoomResponseDTO toResponseDTO(Room entity);

    @Mapping(target = "roomType", ignore = true)
    @Mapping(target = "floor", ignore = true)
    @Mapping(target = "status", source = "status")
    @Mapping(target = "statusCleaning", source = "statusCleaning")
    void updateEntityFromDTO(RoomRequestDTO dto, @MappingTarget Room entity);
}