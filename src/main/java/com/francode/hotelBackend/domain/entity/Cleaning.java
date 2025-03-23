package com.francode.hotelBackend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "limpiezas")
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Room room;

    @Column(name = "fecha_limpieza", nullable = false)
    private LocalDateTime cleaningDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private CleaningStatus status;
}
