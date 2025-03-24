package com.francode.hotelBackend.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentPhotoRequestDTO {
    @JsonProperty("incidencia_id")
    @NotNull(message = "El ID de incidencia no puede ser nulo")
    private Long incidentId;

    @NotNull(message = "La imagen no puede ser nulo")
    private String imageUrl;
}
