package com.francode.hotelBackend.business.services.interfaces;

import com.francode.hotelBackend.business.services.Generic.CrudGenericService;
import com.francode.hotelBackend.domain.entity.Room;
import com.francode.hotelBackend.presentation.dto.request.RoomRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.RoomResponseDTO;

public interface RoomService extends CrudGenericService<Room, RoomRequestDTO, RoomResponseDTO, Long> {
}
