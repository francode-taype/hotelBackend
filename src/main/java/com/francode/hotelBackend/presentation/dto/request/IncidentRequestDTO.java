package com.francode.hotelBackend.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequestDTO {

    @NotEmpty(message = "La descripción no puede estar vacía")
    private String description;
}

