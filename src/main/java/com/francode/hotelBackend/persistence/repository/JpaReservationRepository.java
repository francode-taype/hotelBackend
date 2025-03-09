package com.francode.hotelBackend.persistence.repository;

import com.francode.hotelBackend.domain.entity.Reservation;
import com.francode.hotelBackend.persistence.generics.GenericRepository;

public interface JpaReservationRepository extends GenericRepository<Reservation, Long> {
}
