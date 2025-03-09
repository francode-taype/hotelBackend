package com.francode.hotelBackend.persistence.repository;

import com.francode.hotelBackend.domain.entity.Incident;
import com.francode.hotelBackend.persistence.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaIncidentRepository extends GenericRepository<Incident, Long> {
}
