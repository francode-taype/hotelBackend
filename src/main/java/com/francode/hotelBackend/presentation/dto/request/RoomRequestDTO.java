package com.francode.hotelBackend.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomRequestDTO {

    @NotEmpty(message = "El número de habitación no puede estar vacío")
    @Size(max = 10, message = "El número de habitación no puede tener más de 10 caracteres")
    private String number;

    private String description;

    @NotNull(message = "El precio diario no puede ser nulo")
    @Min(value = 0, message = "El precio diario debe ser mayor o igual a 0")
    private Double dailyPrice;

    @NotNull(message = "El precio por hora no puede ser nulo")
    @Min(value = 0, message = "El precio por hora debe ser mayor o igual a 0")
    private Double hourlyPrice;

    @NotEmpty(message = "El estado no puede estar vacío")
    @Size(max = 50, message = "El estado de habitación no puede tener más de 50 caracteres")
    private String status;

    @JsonProperty("tipo_habitacion_id")
    @NotNull(message = "El ID del tipo de habitación no puede ser nulo")
    private Long roomTypeId;

    @JsonProperty("piso_id")
    @NotNull(message = "El ID del piso no puede ser nulo")
    private Long roomFloorId;
}
