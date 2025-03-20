package com.francode.hotelBackend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reservas")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Room room;

    @Column(name = "fecha_check_in", nullable = false)
    private LocalDateTime checkInDate;

    @Column(name = "fecha_check_out", nullable = false)
    private LocalDateTime checkOutDate;

    @Column(name = "tipo_tarifa")
    private String rateType;

    @Column(name = "precio_tarifa", nullable = false)
    private BigDecimal priceRate;

    @Column(name = "precio_adicional", nullable = true)
    private BigDecimal additionalPrice;

    @Column(name = "precio_total", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "comentarios", nullable = true, length = 255)
    private String comments;

    @Column(name = "estado")
    private String status;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;
}

