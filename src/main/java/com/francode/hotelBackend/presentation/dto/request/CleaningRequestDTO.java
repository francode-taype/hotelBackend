package com.francode.hotelBackend.presentation.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CleaningRequestDTO {
    @NotNull(message = "El ID del empleado no puede ser nulo")
    private Long employeeId;

    @NotNull(message = "El ID de la habitación no puede ser nulo")
    private Long roomId;

    @NotNull(message = "El estado de limpieza no puede ser nulo")
    @Pattern(regexp = "^(EN_PROCESO|TERMINADO|CANCELADO)$", message = "El estado debe ser uno de los siguientes: EN_PROCESO, TERMINADO, CANCELADO")
    private String status;
}
