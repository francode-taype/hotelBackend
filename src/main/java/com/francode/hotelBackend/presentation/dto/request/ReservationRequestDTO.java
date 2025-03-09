package com.francode.hotelBackend.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequestDTO {

    @NotNull(message = "La ID del cliente no puede ser nula")
    private Long clientId;

    @NotNull(message = "La ID de la habitación no puede ser nula")
    private Long roomId;

    @NotNull(message = "La fecha de entrada no puede ser nula")
    private LocalDateTime checkInDate;

    @NotNull(message = "La fecha de salida no puede ser nula")
    private LocalDateTime checkOutDate;

    @NotEmpty(message = "El estado no puede estar vacío")
    private String status;
}

