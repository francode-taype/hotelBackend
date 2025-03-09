package com.francode.hotelBackend.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomRequestDTO {

    @NotEmpty(message = "El número de habitación no puede estar vacío")
    private String number;

    private String description;

    @NotNull(message = "El precio diario no puede ser nulo")
    private Double dailyPrice;

    @NotNull(message = "El precio por hora no puede ser nulo")
    private Double hourlyPrice;

    @NotEmpty(message = "El estado no puede estar vacío")
    private String status;

    @JsonProperty("tipo_habitacion_id")
    @NotNull(message = "El ID del tipo de habitación no puede ser nulo")
    private Long roomTypeId;

    @JsonProperty("piso_id")
    @NotNull(message = "El ID del piso no puede ser nulo")
    private Long roomFloorId;
}
