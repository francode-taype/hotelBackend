package com.francode.hotelBackend.business.services.impl;

import com.francode.hotelBackend.business.mapper.RoomMapper;
import com.francode.hotelBackend.business.services.interfaces.RoomService;
import com.francode.hotelBackend.domain.entity.FloorRooms;
import com.francode.hotelBackend.domain.entity.Room;
import com.francode.hotelBackend.domain.entity.RoomType;
import com.francode.hotelBackend.exceptions.custom.NoRecordsException;
import com.francode.hotelBackend.exceptions.custom.NotFoundException;
import com.francode.hotelBackend.exceptions.custom.ValidationException;
import com.francode.hotelBackend.persistence.repository.JpaFloorRoomsRepository;
import com.francode.hotelBackend.persistence.repository.JpaRoomRepository;
import com.francode.hotelBackend.persistence.repository.JpaRoomTypeRepository;
import com.francode.hotelBackend.presentation.dto.request.RoomRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.RoomResponseDTO;
import jakarta.persistence.criteria.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final JpaRoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final JpaRoomTypeRepository roomTypeRepository;
    private final JpaFloorRoomsRepository floorRoomsRepository;

    @Autowired
    public RoomServiceImpl(JpaRoomRepository roomRepository, RoomMapper roomMapper,
                           JpaRoomTypeRepository roomTypeRepository, JpaFloorRoomsRepository floorRoomsRepository) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.roomTypeRepository = roomTypeRepository;
        this.floorRoomsRepository = floorRoomsRepository;
    }

    @Override
    public Optional<RoomResponseDTO> findById(Long id) {
        if (id == null) {
            throw new ValidationException("El ID de la habitación no puede ser nulo.");
        }
        return roomRepository.findById(id)
                .map(roomMapper::toResponseDTO)
                .or(() -> {
                    throw new NotFoundException("No se encontró una habitación con el ID: " + id);
                });
    }

    @Override
    public RoomResponseDTO create(RoomRequestDTO roomRequestDTO) {
        if (roomRequestDTO == null) {
            throw new ValidationException("La solicitud de creación de habitación no puede ser nula.");
        }

        RoomType roomType = roomTypeRepository.findById(roomRequestDTO.getRoomTypeId())
                .orElseThrow(() -> new NotFoundException("No se encontró un tipo de habitación con el ID: " + roomRequestDTO.getRoomTypeId()));

        FloorRooms floor = floorRoomsRepository.findById(roomRequestDTO.getRoomFloorId())
                .orElseThrow(() -> new NotFoundException("No se encontró un piso con el ID: " + roomRequestDTO.getRoomFloorId()));


        Room room = roomMapper.toEntity(roomRequestDTO);
        room.setRoomType(roomType);
        room.setFloor(floor);

        return roomMapper.toResponseDTO(roomRepository.save(room));
    }

    @Override
    public RoomResponseDTO update(Long id, RoomRequestDTO roomRequestDTO) {
        if (id == null) {
            throw new ValidationException("El ID de la habitación no puede ser nulo.");
        }

        if (roomRequestDTO == null) {
            throw new ValidationException("La solicitud de actualización de habitación no puede ser nula.");
        }

        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró una habitación con el ID: " + id));

        RoomType roomType = roomTypeRepository.findById(roomRequestDTO.getRoomTypeId())
                .orElseThrow(() -> new NotFoundException("No se encontró un tipo de habitación con el ID: " + roomRequestDTO.getRoomTypeId()));

        FloorRooms floor = floorRoomsRepository.findById(roomRequestDTO.getRoomFloorId())
                .orElseThrow(() -> new NotFoundException("No se encontró un piso con el ID: " + roomRequestDTO.getRoomFloorId()));

        roomMapper.updateEntityFromDTO(roomRequestDTO, existingRoom);
        existingRoom.setRoomType(roomType);
        existingRoom.setFloor(floor);

        return roomMapper.toResponseDTO(roomRepository.save(existingRoom));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new ValidationException("El ID de la habitación no puede ser nulo.");
        }

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró una habitación con el ID: " + id));

        roomRepository.delete(room);
    }

    @Override
    public Page<RoomResponseDTO> findAll(String field, String value, Pageable pageable) {
        if ((field != null && value == null) || (field == null && value != null)) {
            throw new ValidationException("Ambos, campo y valor, deben proporcionarse para la búsqueda.");
        }

        Specification<Room> spec = Specification.where(null);

        if (field != null && value != null && !field.isEmpty() && !value.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                Path<String> fieldPath = root.get(field);
                return criteriaBuilder.like(criteriaBuilder.lower(fieldPath), "%" + value.toLowerCase() + "%");
            });
        }

        Page<Room> rooms = roomRepository.findAll(spec, pageable);

        if (rooms.isEmpty()) {
            throw new NoRecordsException("Todavía no hay registros disponibles.");
        }

        return rooms.map(roomMapper::toResponseDTO);
    }
}