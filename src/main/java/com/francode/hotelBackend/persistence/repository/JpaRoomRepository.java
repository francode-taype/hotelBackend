package com.francode.hotelBackend.persistence.repository;

import com.francode.hotelBackend.domain.entity.Room;
import com.francode.hotelBackend.persistence.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoomRepository extends GenericRepository<Room, Long> {
}
