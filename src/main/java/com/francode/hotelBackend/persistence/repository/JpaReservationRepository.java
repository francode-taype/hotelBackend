package com.francode.hotelBackend.persistence.repository;

import com.francode.hotelBackend.domain.entity.Reservation;
import com.francode.hotelBackend.persistence.generics.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
}
