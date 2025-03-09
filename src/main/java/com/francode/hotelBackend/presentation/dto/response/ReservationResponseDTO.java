package com.francode.hotelBackend.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponseDTO {

    private Long id;
    private Long clientId;
    private Long roomId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private String status;
}
